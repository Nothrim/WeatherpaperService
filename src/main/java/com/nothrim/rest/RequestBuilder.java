package com.nothrim.rest;

import java.util.Map;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface RequestBuilder {
    public void append(StringBuilder sb,String data);
    public void appendParameter(StringBuilder sb,Map.Entry<String,String> data);
}
