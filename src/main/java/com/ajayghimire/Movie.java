package com.ajayghimire;

public class Movie {
  private String title;
  private int year;
  private double price;


  public Movie(String t, int y, double p) {
    this.title = t;
    this.year = y;
    this.price = p;
  }

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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
