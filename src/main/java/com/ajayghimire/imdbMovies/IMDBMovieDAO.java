package com.ajayghimire.imdbMovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBMovieDAO {

  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/imdbMovies");
  }



  public List<Map<String, String>> getFavouriteMovies() {
    IMDBMovie imdbMovie = new IMDBMovie();
    List<Map<String, String>> favouriteMovies = new ArrayList<>();

    try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM movies");) {
      while (resultSet.next()) {
        imdbMovie.setTitle(resultSet.getString("title"));
        imdbMovie.setYear(resultSet.getInt("year"));
        imdbMovie.setPlot(resultSet.getString("plot"));
        imdbMovie.setGenres(resultSet.getString("genres"));
        imdbMovie.setRating(resultSet.getDouble("rating"));
        favouriteMovies.add(imdbMovie.toIMDBMovieMap());
      }
    } catch (SQLException e) {
      System.err.println("Cannot establish connection to DB for getting favourite movies.");
      e.printStackTrace();
    }


    System.out.println(favouriteMovies);
    return favouriteMovies;
  }

  public void addToFavourites(String title, int year, double rating, String genres, String plot) {
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO movies (title, year, rating, genres, plot) VALUES (?, ?, ?, ?, ?)");) {
      statement.setString(1, title);
      statement.setInt(2, year);
      statement.setDouble(3, rating);
      statement.setString(4, genres);
      statement.setString(5, plot);



    } catch (SQLException e) {
      System.err.println("Cannot establish connection to DB for adding to favourite movies.");
      e.printStackTrace();
    }


  }

}
