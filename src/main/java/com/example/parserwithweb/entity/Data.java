package com.example.parserwithweb.entity;

import java.util.UUID;

public class Data implements DomainObject {

    private UUID id;
    private String content;

    public Data(UUID id, String description) {
        this.id = id;
        this.content = description;
    }

    public Data() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}