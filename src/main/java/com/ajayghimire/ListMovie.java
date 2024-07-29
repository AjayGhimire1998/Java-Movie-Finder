package com.ajayghimire;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListMovie
 */
public class ListMovie extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArrayList<Movie> movies = MovieIO.getMovies();
    request.setAttribute("movies", movies);
    request.setAttribute("number", movies.size());
    RequestDispatcher dispatcher = request.getRequestDispatcher("ListMovie.jsp");
    dispatcher.forward(request, response);

  }

}
