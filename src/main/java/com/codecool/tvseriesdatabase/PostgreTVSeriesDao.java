package com.codecool.tvseriesdatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreTVSeriesDao implements TVSeriesDao{
    public Connection getConnection(){

        Connection connection = null;
        String userName = "papa";
        String password = "password";
        String host = "localhost";
        String databaseName = "tv_series";


        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":5432/" + databaseName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void add(Series series){
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO series (title, num_of_seasons, genre) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, series.getTitle());
            st.setInt(2, series.getNumberOfSeasons());
            st.setString(3, series.getGenre());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Connection failed!", e);
        }
     }

    public void update(Series series){
        try (Connection con = getConnection()) {
            String sql = "UPDATE series SET title = ?, num_of_seasons = ?, genre = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, series.getTitle());
            st.setInt(2, series.getNumberOfSeasons());
            st.setString(3, series.getGenre());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void delete(String titleToDelete) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM series WHERE title = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, titleToDelete);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Series> filterByGenre(String genre) {
        List<Series> filteredSeries = new ArrayList<>();
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM series WHERE genre = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, genre);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Series series = new Series(rs.getString(1), rs.getInt(2), rs.getString(3));
                filteredSeries.add(series);
            }
            return filteredSeries;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void createTable() {
        try (Connection con = getConnection()) {
            String sql = "CREATE TABLE series (\n" +
                    "    title varchar PRIMARY KEY,\n" +
                    "    num_of_seasons smallint,\n" +
                    "    genre varchar" +
                    ");";
            Statement st = con.createStatement();
            st.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void dropTable() {
        try (Connection con = getConnection()) {
            String sql = "DROP TABLE IF EXISTS series;";
            Statement st = con.createStatement();
            st.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        //TODO: implement this. It should drop table called series if its exists on the db.
    }
}


