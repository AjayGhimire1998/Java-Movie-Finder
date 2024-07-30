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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IMDBMoviesServlet
 */
public class IMDBMoviesServlet extends HttpServlet {

  private static final long serialVersionUID = 907035272659756327L;
  private static final String API_KEY = "1f4503a2";



  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    System.out.println(title);
    if (title != null && !title.trim().isEmpty()) {
      String jsonResponse = searchMovies(title);

      if (jsonResponse != null) {
        JSONObject moviesData = new JSONObject(new JSONTokener(jsonResponse));
        JSONArray moviesArray;
        try {
          moviesArray = moviesData.getJSONArray("Search");
          List<Map<String, String>> movieList = new ArrayList<>();

          System.out.println(moviesData);
          for (int i = 0; i < moviesArray.length(); i++) {
            JSONObject movieData = moviesArray.getJSONObject(i);

            // movieDetails.put("Title", movieData.optString("Title"));
            String movieTitle = movieData.optString("Title");
            String singleMovieData = searchMovie(movieTitle);
            JSONObject singleMovieJSON = new JSONObject(new JSONTokener(singleMovieData));

            Map<String, String> movieDetails = new HashMap<>();
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
