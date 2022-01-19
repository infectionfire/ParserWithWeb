package com.example.parserwithweb.entity;

import java.util.UUID;


public class Data implements DomainObject {

    private UUID id;
    private String url;
    private String description;


    public Data() {

    }

    public Data(UUID id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}