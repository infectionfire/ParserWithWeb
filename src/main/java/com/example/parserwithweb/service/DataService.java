package com.example.parserwithweb.service;

import java.util.Set;

public interface DataService {

    public boolean persist(String search);

    public Set<String> getRandomData();
}