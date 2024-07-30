package com.ajayghimire.imdbMovies;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IMDBSavedMoviesServlet
 */
public class IMDBSavedMoviesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public IMDBSavedMoviesServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");

    IMDBMovieDAO imdbMovieDAO = new IMDBMovieDAO();
    IMDBMovie movie = imdbMovieDAO.getImdbMovie();
    // imdbMovieDAO.getImdbMovie();
    request.setAttribute("fav", movie);

    request.getRequestDispatcher("favourites.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
