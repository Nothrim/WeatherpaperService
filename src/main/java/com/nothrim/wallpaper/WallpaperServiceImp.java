package com.nothrim.wallpaper;

import com.nothrim.database.models.images.ApiCall;
import com.nothrim.database.models.images.Image;
import com.nothrim.database.models.security.User;
import com.nothrim.database.repositories.images.APICallRepository;
import com.nothrim.database.repositories.images.ImageRepository;
import com.nothrim.database.repositories.security.UserRepository;
import com.nothrim.database.repositories.weather.WeatherRepository;
import com.nothrim.imgur.ImgurAPI;
import com.nothrim.json.weather.CurrentObservation;
import com.nothrim.json.weather.Weather;
import com.nothrim.weather.WeatherAPI;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Notrim on 08.05.2017.
 */
@Service
public class WallpaperServiceImp implements WallpaperService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WallpaperServiceImp.class);
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    APICallRepository apiCallRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WeatherAPI weatherAPI;
    @Autowired
    ImgurAPI imgurAPI;

    @Override
    public String getWallpaperURL(String userName, boolean skip) {
        User user = userRepository.findByUsername(userName);
        if (user != null) {
            if (skip && user.getCurrentImage() != null) {
                Image currentImage = user.getCurrentImage();
                currentImage.setSkipCount(currentImage.getSkipCount() + 1);
                imageRepository.save(currentImage);
            }
            com.nothrim.database.models.weather.Weather weather = user.getWeather();
            Weather w;
            if (weather == null) {
                weather = new com.nothrim.database.models.weather.Weather();
            }
            ApiCall apiCall = weather.getApiCall();
            String call = "";
            if (weather.getLastCall() == null || new Date().getTime() - weather.getLastCall().getTime() > 3600000L) {
                w = weatherAPI.getWeatherForPosition(user.getLongitude(), user.getLatitude());
                if (w != null) {
                    weather.setLastCall(new Date());
                    Set<User> users = weather.getUsers();
                    if (users == null)
                        users = new HashSet<>();
                    users.add(user);
                    weather.setUsers(users);
                    weather.mapJSON(w.getCurrentObservation());
                    call = mapConditionsToAPICall(weather.getJSON());
                    apiCall = apiCallRepository.findFirstByCall(call);
                    if (apiCall != null)
                        weather.setApiCall(apiCall);
                    weatherRepository.save(weather);
                    user.setWeather(weather);
                    userRepository.save(user);
                }
            } else {
                call = mapConditionsToAPICall(weather.getJSON());
                apiCall = apiCallRepository.findFirstByCall(call);
            }
            if (apiCall == null) {
                apiCall = new ApiCall();
                apiCall.setCount(1);
                apiCall.setCall(call);
                final ApiCall finalApiCall = apiCall;
                apiCall.setImages(
                        imgurAPI.galleryGetAllForQuery(apiCall.getCall(),
                                Long.toString(apiCall.getCount())).getItems().stream().filter(e -> !e.isAlbum())
                                .map(img -> {
                                    Image dbImage = new Image();
                                    dbImage.mapFromJSON(img);
                                    dbImage.setApiCall(finalApiCall);
                                    return dbImage;
                                }).collect(Collectors.toSet()));
                apiCallRepository.save(apiCall);
                weather.setApiCall(apiCall);
                weatherRepository.save(weather);
            }
            Image image = null;
            if (apiCall.getImages() != null)
                image = apiCall.getImages().stream().filter(img -> img.getUsers() == null || !img.getUsers().contains(user)).findAny().orElse(null);
            if (image == null) {
                apiCall.setCount(apiCall.getCount() + 1);
                final ApiCall finalApiCall = apiCall;
                Set<Image> dbImages = apiCall.getImages() != null ? apiCall.getImages() : new HashSet<>();
                imgurAPI.galleryGetAllForQuery(apiCall.getCall(),
                        Long.toString(apiCall.getCount())).getItems().stream().filter(e -> !e.isAlbum()).forEach(img -> {
                    Image dbImage = new Image();
                    dbImage.setApiCall(finalApiCall);
                    dbImage.mapFromJSON(img);
                    dbImages.add(dbImage);
                    imageRepository.save(dbImage);
                });
                apiCall.setImages(dbImages);
                apiCallRepository.save(apiCall);
            }
            image = apiCall.getImages().stream().filter(img -> img.getUsers() == null || !img.getUsers().contains(user)).findAny().orElse(null);
            if (image != null) {
                image.setUsageCount(image.getUsageCount() + 1);
                Set<User> users = image.getUsers();
                if (users == null)
                    users = Stream.of(user).collect(Collectors.toSet());
                else
                    users.add(user);
                image.setUsers(users);
                imageRepository.save(image);
                user.getImages().add(image);
                user.setCurrentImage(image);
                userRepository.save(user);

                return image.getUrl();
            }
        }
        return null;
    }

    public static String mapConditionsToAPICall(CurrentObservation conditions) {
        StringBuilder tags = new StringBuilder();
        float temperature = Float.parseFloat(conditions.getFeelslikeC());
        if (conditions.getRelativeHumidity() != null && Float.parseFloat(conditions.getRelativeHumidity()
                .trim().replace("%", "")) > 60) {
            if (temperature > 0) {
                tags.append("rain");
            } else {
                tags.append("snow");
            }
        }
        if (temperature > 15 && temperature < 25) {
            tags.append(",hot,sunny");
        }
        if (temperature > 30)
            tags.append(",summer");
        if (temperature < 0)
            tags.append(",winter");
        if (temperature > 0 && temperature < 15)
            tags.append(",chilly");
        if (conditions.getWindGustKph() != null && Float.parseFloat(conditions.getWindGustKph()) > 60)
            tags.append(",hurricane");
        if (tags.charAt(0) == ',')
            tags.deleteCharAt(0);
        return tags.toString();
    }
}

