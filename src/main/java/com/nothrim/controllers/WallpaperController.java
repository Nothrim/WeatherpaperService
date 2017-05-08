package com.nothrim.controllers;

import com.nothrim.database.models.images.Image;
import com.nothrim.database.models.security.User;
import com.nothrim.database.repositories.security.UserRepository;
import com.nothrim.wallpaper.WallpaperService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Notrim on 08.05.2017.
 */
@RestController
@RequestMapping("/api")
public class WallpaperController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WallpaperController.class);

    @Autowired
    WallpaperService wallpaperService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/wallpaper", method = RequestMethod.GET)
    public String wallpaper(Authentication authentication, @RequestParam(value = "skip", required = false) Boolean skip) {
        if (skip == null) skip = false;
        return wallpaperService.getWallpaperURL(authentication.getName(), skip);
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public String wallpaper(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Image img = user.getCurrentImage();
        if (img != null) {
            String message;
            if (user.getFavImages().contains(img)) {
                user.getFavImages().remove(img);
                message = "\"You removed " + img.getUrl() + " from favourites\"";

            } else {
                user.getFavImages().add(img);
                userRepository.save(user);
                message = "\"You added " + img.getUrl() + " to favourites\"";
            }
            userRepository.save(user);
            return "{\"status\":\"SUCCESS\",\"message\":" + message + "}";
        }
        return "{\"status\":\"FAILURE\",\"message\":\"You have no current image pulled from application\"}";
    }

    @RequestMapping(value = "/user/position", method = RequestMethod.GET)
    public String userPosition(Authentication authentication, float latitude, float longitude) {
        User user = userRepository.findByUsername(authentication.getName());
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        userRepository.save(user);
        return "{\"status\":\"SUCCESS\"}";
    }

}
