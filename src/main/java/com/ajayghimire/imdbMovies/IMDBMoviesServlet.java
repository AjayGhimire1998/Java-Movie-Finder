package com.ajayghimire.imdbMovies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IMDBMoviesServlet
 */
public class IMDBMoviesServlet extends HttpServlet {



  private static final long serialVersionUID = 907035272659756327L;
  private static final String API_KEY = Dotenv.load().get("OMDB_API_KEY");



  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    if (title != null && !title.trim().isEmpty()) {
      String jsonResponse = searchMovies(title);

      if (jsonResponse != null) {
        JSONObject moviesData = new JSONObject(new JSONTokener(jsonResponse));
        JSONArray moviesArray;
        try {
          moviesArray = moviesData.getJSONArray("Search");
          List<Map<String, String>> movieList = new ArrayList<>();
          for (int i = 0; i < moviesArray.length(); i++) {
            JSONObject movieData = moviesArray.getJSONObject(i);

            String movieTitle = movieData.optString("Title");
            String singleMovieData = searchMovie(movieTitle);
            JSONObject singleMovieJSON = new JSONObject(new JSONTokener(singleMovieData));

            Map<String, String> movieDetails = new HashMap<String, String>();
            movieDetails.put("Title", singleMovieJSON.optString("Title"));
            movieDetails.put("Plot", singleMovieJSON.optString("Plot"));
            movieDetails.put("Year", singleMovieJSON.optString("Year"));
            movieDetails.put("Genre", singleMovieJSON.optString("Genre"));
            movieDetails.put("imdbRating", singleMovieJSON.optString("imdbRating"));
            movieDetails.put("Poster", singleMovieJSON.optString("Poster"));

            movieList.add(movieDetails);
          }


          request.setAttribute("movieList", movieList);
        } catch (JSONException e) {
          // TODO Auto-generated catch block
          request.setAttribute("error", moviesData);
        }



      }
    }

    request.getRequestDispatcher("index.jsp").forward(request, response);
  }



  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String title = req.getParameter("title");
    int year = Integer.parseInt(req.getParameter("year").replaceAll("\\D", "").substring(0, 4));
    String genre = req.getParameter("genre");
    double rating = Double.parseDouble(req.getParameter("rating").replaceAll("\\D", "0"));
    String plot = req.getParameter("plot");
    String poster = req.getParameter("poster");


    if (!IMDBMovieDAO.movieExits(title, year)) {
      IMDBMovieDAO.addToFavourites(title, year, rating, genre, plot, poster);
    }


    resp.sendRedirect("/favourites");
  }



  private String searchMovies(String title) {
    String apiUrlBuilder =
        String.format("http://www.omdbapi.com/?s=%s&apikey=%s", title.replace(" ", "+"), API_KEY);

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(apiUrlBuilder)).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


      return response.body();
      // }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return null;

  }

  private String searchMovie(String title) {
    String apiUrlBuilder =
        String.format("http://www.omdbapi.com/?t=%s&apikey=%s", title.replace(" ", "+"), API_KEY);
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(apiUrlBuilder)).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


      return response.body();
      // }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }



}
