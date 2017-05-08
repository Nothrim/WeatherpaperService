package com.nothrim.iplocation;


/**
 * Created by Notrim on 24.04.2017.
 */
public interface ServerLocationBo {
    com.nothrim.json.location.ServerLocation getLocation(String ipAddress);
}
