package com.ajayghimire;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMovies extends HttpServlet {
  private static final long serialVersionUID = 3036351381523156732L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ArrayList<Movie> movies = MovieIO.getMovies();
    req.setAttribute("movies", movies);
    req.setAttribute("number", movies.size());
    req.getRequestDispatcher(
        "/Users/ajayghimire/eclipse-workspace/my-web-app/src/main/webapp/ListMovies.jsp")
        .forward(req, resp);
  }
}
