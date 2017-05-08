package com.nothrim.imgur;

import com.nothrim.json.imgur.Data;
import com.nothrim.json.imgur.Image;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface ImgurAPI {
    public Data<Image> gallerySearchSimple(String query, String sort, String window, String page);

    public Data<Image> gallerySearchAll(String q_all, String q_size_px, String sort, String window, String page);

    public Data<Image> gallerySearch(String q_all, String q_any, String q_exactly, String q_not, String q_type,
                                     String q_size_px, String sort, String window, String page);

    public Data<Image> gallerySearchAny(String q_any,
                                        String q_size_px, String sort, String window, String page);

    public Data<Image> albumImages(String ablumId);

    public Data<Image> galleryGetAllForQuery(String q_any,String page);
}
