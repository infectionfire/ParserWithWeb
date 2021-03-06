package com.example.parserwithweb.repository;

import com.example.parserwithweb.entity.DomainObject;

import java.sql.SQLException;
import java.util.Set;

public interface DataRepository<V extends DomainObject> {

    void persist(V object) throws SQLException;

    void delete(V object);

    Set<String> getRandomData();

}