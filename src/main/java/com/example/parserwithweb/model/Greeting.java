package com.example.parserwithweb.model;

import java.io.IOException;

import static com.example.parserwithweb.config.StructureCardBuilder.BuildDescription;

public class Greeting {

    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws IOException {
        content = BuildDescription(content);
        this.content = content;
    }

}