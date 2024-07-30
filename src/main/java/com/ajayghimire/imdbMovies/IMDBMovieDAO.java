package com.ajayghimire.imdbMovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IMDBMovieDAO {


  public IMDBMovie getImdbMovie() {
    IMDBMovie imdbMovie = new IMDBMovie();



    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imdbMovies", "postgres",
          "Ajay123");

      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM movies");
      while (rs.next()) {
        imdbMovie.setTitle(rs.getString("title"));
        imdbMovie.setYear(rs.getInt("year"));
        imdbMovie.setPlot(rs.getString("plot"));
        imdbMovie.setGenres(rs.getString("genres"));
        imdbMovie.setRating(rs.getDouble("rating"));

      }
      rs.close();
      st.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    // IMDBMovie imdbMovie = new IMDBMovie();
    // imdbMovie.setTitle("ajay");
    // imdbMovie.setRating(1.9);
    // imdbMovie.setYear(2024);
    // imdbMovie.setPlot("ehhehehaf fasghfjkasgkfa kgfagfs");
    //
    if (conn == null) {
      System.out.println("Connection is not made!");
    }
    System.out.println(imdbMovie);
    return imdbMovie;
  }

}
