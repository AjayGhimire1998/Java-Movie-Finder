package com.ajayghimire.imdbMovies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;
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
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    System.out.println(title);
    if (title != null && !title.trim().isEmpty()) {
      String jsonResponse = searchMovie(title);
      if (jsonResponse != null) {
        JSONObject movieData = new JSONObject(new JSONTokener(jsonResponse));
        Map<String, String> movieDetails = new HashMap<>();
        movieDetails.put("Title", movieData.optString("Title"));
        movieDetails.put("Year", movieData.optString("Year"));
        movieDetails.put("Genre", movieData.optString("Genre"));
        movieDetails.put("imdbRating", movieData.optString("imdbRating"));
        movieDetails.put("Poster", movieData.optString("Poster"));
        request.setAttribute("movieDetails", movieDetails);
      }
    }
    request.getRequestDispatcher("index.jsp").forward(request, response);
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
