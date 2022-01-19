package com.example.parserwithweb.service;

import com.example.parserwithweb.entity.Data;

import java.util.Set;

public interface DataService {

    public boolean persist(Data search);

    public Set<String> getRandomData();
}