package com.nothrim.json.imgur;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Notrim on 25.04.2017.
 */
public class Data<T> {
    @JsonProperty("data")
    private List<T> items;
    private boolean success;
    private int status;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "items=" + items +
                ", success=" + success +
                ", status=" + status +
                '}';
    }
}
