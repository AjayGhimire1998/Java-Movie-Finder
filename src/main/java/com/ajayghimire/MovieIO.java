package com.ajayghimire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class MovieIO {
  public static ArrayList<Movie> getMovies() {
    ArrayList<Movie> movies = new ArrayList<>();
    BufferedReader reader = getReader(
        "/Users/ajayghimire/eclipse-workspace/my-web-app/src/main/webapp/moviejsp/movies.txt");
    Movie movie = readMovie(reader);

    while (movie != null) {
      movies.add(movie);
      movie = readMovie(reader);
    }
    return movies;
  }

  private static BufferedReader getReader(String name) {
    BufferedReader in = null;

    try {
      File file = new File(name);
      System.out.println(file.exists());
      in = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      System.err.println("File doesn't exist!");
      System.exit(0);
    }

    return in;
  }

  private static Movie readMovie(BufferedReader in) {
    String line = "";

    try {
      line = in.readLine();
    } catch (IOException e) {
      System.err.println("IO error occured!");
    }

    if (line == null) {
      return null;
    } else {
      String[] data = line.split("\t");
      return new Movie(data[0], Integer.parseInt(data[1]),
          Double.parseDouble((data[2]).substring(2)));
    }

  }


}