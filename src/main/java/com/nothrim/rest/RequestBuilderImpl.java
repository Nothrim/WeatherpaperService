package com.nothrim.rest;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Notrim on 08.05.2017.
 */
public class RequestBuilderImpl implements RequestBuilder {
    @Override
    public void append(StringBuilder sb, String data) {
        if (data != null && data.length() > 0)
            sb.append("/").append(data);
    }

    @Override
    public void appendParameter(StringBuilder sb, Map.Entry<String, String> data) {
        if (data != null && data.getValue() != null && data.getValue().length() > 0) {
            if (data.getValue().contains("+")) {
                Arrays.stream(data.getValue().split("\\+")).forEach(e -> {
                    sb.append("&").append(data.getKey()).append("=").append(e);
                });
            } else
                sb.append("&").append(data.getKey()).append("=").append(data.getValue());
        }
    }
}
