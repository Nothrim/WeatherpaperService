package com.nothrim.wallpaper;

import com.nothrim.database.models.security.User;

/**
 * Created by Notrim on 07.05.2017.
 */
public interface WallpaperService {
    String getWallpaperURL(String userName,boolean skip);
}
