package com.example.parserwithweb.repository;

import com.example.parserwithweb.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

@Repository("dataRespitory")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Data object) {

        Object[] params = new Object[] {  object.getDescription(), object.getUrl() };
        int[] types = new int[] {  Types.VARCHAR, Types.VARCHAR };

        jdbcOperations.update("INSERT INTO parse_values(" +
                "            data_description, data_url)\n" +
                "    VALUES ( ?, ?);", params, types);
    }

    @Override
    public void delete(Data object) {
        jdbcOperations.update("DELETE FROM parse_values" +
                " WHERE data_id = '" + object.getId() + "';");
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> result = new HashSet<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT data_description FROM" +
                " parse_values p ORDER BY RANDOM() LIMIT 50;");
        while (rowSet.next()) {
            result.add(rowSet.getString("data_description"));
        }
        return result;
    }


}