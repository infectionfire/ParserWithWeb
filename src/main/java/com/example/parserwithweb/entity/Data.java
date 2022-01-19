package com.example.parserwithweb.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class Data implements DomainObject {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String url;
    private String description;


    public Data() {

    }

    public Data(long id, String url, String description) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}