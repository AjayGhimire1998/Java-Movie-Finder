package com.ajayghimire.imdbMovies;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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

    List<Map<String, String>> favouriteMovies = IMDBMovieDAO.getFavouriteMovies();
    // imdbMovieDAO.getImdbMovie();
    request.setAttribute("fav", favouriteMovies);

    request.getRequestDispatcher("favourites.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String title = req.getParameter("title");

    IMDBMovieDAO.deleteMovieFromFavourite(title);
    resp.sendRedirect("/favourites");


  }



}
