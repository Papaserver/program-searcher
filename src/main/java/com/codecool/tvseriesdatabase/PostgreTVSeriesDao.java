package com.codecool.tvseriesdatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreTVSeriesDao implements TVSeriesDao{
    public Connection getConnection(){
        //TODO: rewrite this method to use your own db
        Connection connection = null;
        String userName = "myuser";
        String password = "mypass";
        String host = "localhost";
        String databaseName = "test";


        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":5432/" + databaseName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void add(Series series){
        //TODO: implement this to add a new row to series table which contains data of series from the paramater
    }

    public void update(Series series){
        //TODO: implement this. It should update series in db which has the same title as the series in the parameter
        // to have the same data as the series in parameter.
    }

    public void delete(String titleToDelete) {
        //TODO: implement this. It should delete series with title given in parameter.
    }

    public List<Series> filterByGenre(String genre) {
        //TODO: implement this. It should return list of series filtered by genre.
        return null;
    }

    public void createTable() {
        //TODO: implement this. It should create table named series. columns should be title as primary key, num_of_seasons, genre
    }

    public void dropTable() {
        //TODO: implement this. It should drop table called series if its exists on the db.
    }
}


