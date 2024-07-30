package com.ajayghimire.imdbMovies;

import java.util.HashMap;
import java.util.Map;

public class IMDBMovie {
  private String title;
  private int year;
  private double rating;
  private String genres;
  private String plot;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getGenres() {
    return genres;
  }

  public void setGenres(String genres) {
    this.genres = genres;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public Map<String, String> toIMDBMovieMap() {
    Map<String, String> movieMap = new HashMap<>();
    movieMap.put("title", this.title);
    movieMap.put("year", Integer.toString(this.year));
    movieMap.put("rating", Double.toString(this.rating));
    movieMap.put("genres", this.genres);
    movieMap.put("plot", this.plot);
    return movieMap;

  }

  @Override
  public String toString() {
    return "IMDBMovie [title=" + title + ", year=" + year + ", rating=" + rating + ", genres="
        + genres + ", plot=" + plot + "]";
  }


}
