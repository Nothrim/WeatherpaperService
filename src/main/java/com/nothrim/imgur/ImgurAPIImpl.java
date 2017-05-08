package com.nothrim.imgur;

import com.nothrim.json.imgur.Data;
import com.nothrim.json.imgur.Image;
import com.nothrim.rest.RequestBuilderImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Notrim on 24.04.2017.
 */
@Service
public class ImgurAPIImpl extends RequestBuilderImpl implements ImgurAPI {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ImgurAPIImpl.class);

    private static final String KEY = "15cdd98dde3d1bb";
    private static final String API_URI = "https://api.imgur.com/3";

    @Autowired
    private RestTemplate restTemplate;

    public String getKey() {
        return KEY;
    }

    @Override
    public Data<Image> gallerySearchSimple(String query, String sort, String window, String page) {
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder
                .append(API_URI)
                .append("/gallery/search");
        if (sort != null && sort.length() > 0) {
            requestBuilder.append("/").append(sort);
            append(requestBuilder, window);
        }
        append(requestBuilder, page);
        if (query != null && query.length() > 0)
            requestBuilder.append("?q=").append(query);
        return restTemplate.exchange(
                requestBuilder.toString(), HttpMethod.GET, getEntityWithHeader(),
                new ParameterizedTypeReference<Data<Image>>() {
                }).getBody();
    }

    @Override
    public Data<Image> gallerySearchAll(String q_all, String q_size_px, String sort, String window, String page) {
        return gallerySearch(q_all, null, null, null, null, q_size_px, sort, window, page);
    }

    @Override
    public Data<Image> gallerySearch(String q_all, String q_any, String q_exactly, String q_not, String q_type,
                                     String q_size_px, String sort, String window, String page) {
        StringBuilder requestBuilder = new StringBuilder();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("q_all", q_all);
        parameters.put("q_any", q_any);
        parameters.put("q_exactly", q_exactly);
        parameters.put("q_not", q_not);
        parameters.put("q_type", q_type);
        parameters.put("q_size_px", q_size_px);
        requestBuilder
                .append(API_URI)
                .append("/gallery/search");
        if (sort != null && sort.length() > 0) {
            requestBuilder.append("/").append(sort);
            append(requestBuilder, window);
        }
        append(requestBuilder, page);
        Map.Entry<String, String> entry = parameters.entrySet().stream().filter(e -> e.getValue() != null).findFirst().orElse(null);
        if (entry != null) {
            parameters.remove(entry.getKey());
            requestBuilder.append("?").append(entry.getKey()).append("=").append(entry.getValue());
            parameters.entrySet().forEach(e -> appendParameter(requestBuilder, e));
        }
        log.info(requestBuilder.toString());
        return restTemplate.exchange(
                requestBuilder.toString(), HttpMethod.GET, getEntityWithHeader(),
                new ParameterizedTypeReference<Data<Image>>() {
                }).getBody();
    }

    @Override
    public Data<Image> gallerySearchAny(String q_any, String q_size_px, String sort, String window, String page) {
        return gallerySearch(null, q_any, null, null, null, q_size_px, sort, window, page);
    }

    @Override
    public Data<Image> albumImages(String albumId) {
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder
                .append(API_URI)
                .append("/album/")
                .append(albumId)
                .append("/images");
        return restTemplate.exchange(
                requestBuilder.toString(), HttpMethod.GET, getEntityWithHeader(),
                new ParameterizedTypeReference<Data<Image>>() {
                }).getBody();
    }

    @Override
    public Data<Image> galleryGetAllForQuery(String q_any, String page) {
        Data<Image> imageData = gallerySearch(null,q_any,"","meme,funny,nsfw,sex","png", "5000-10000px", "top", "all", page);
//        imageData.getItems().addAll(imageData.getItems().stream().filter(Image::isAlbum).flatMap(album -> albumImages
//                (album.getId()).getItems().stream()).collect(Collectors.toList()));
        return imageData;
    }


    private HttpEntity getEntityWithHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + KEY);
        return new HttpEntity(headers);
    }
}
