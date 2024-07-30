package com.ajayghimire.imdbMovies;

import java.sql.Connection;
import java.sql.DriverManager;
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

    try {
      Connection conn = getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM movies");
      while (rs.next()) {
        imdbMovie.setTitle(rs.getString("title"));
        imdbMovie.setYear(rs.getInt("year"));
        imdbMovie.setPlot(rs.getString("plot"));
        imdbMovie.setGenres(rs.getString("genres"));
        imdbMovie.setRating(rs.getDouble("rating"));
        favouriteMovies.add(imdbMovie.toIMDBMovieMap());
      }
      rs.close();
      st.close();
    } catch (SQLException e) {
      System.err.println("Cannot establish connection to DB for getting favourite movies.");
      e.printStackTrace();
    }


    System.out.println(favouriteMovies);
    return favouriteMovies;
  }

  public void addToFavourites() {
    try {
      Connection conn = getConnection();


    } catch (SQLException e) {
      System.err.println("Cannot establish connection to DB for adding to favourite movies.");
      e.printStackTrace();
    }


  }

}
