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
import org.json.JSONObject;
import org.json.JSONTokener;

public class IMDBMovieDAO {
  private static final String API_KEY = "1f4503a2";


  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException {
    String apiUrlBuilder =
        String.format("http://www.omdbapi.com/?s=%s&apikey=%s", "batman", API_KEY);

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(apiUrlBuilder)).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


      String jsonResponse = response.body();
      System.out.println(jsonResponse);

      JSONObject moviesData = new JSONObject(new JSONTokener(jsonResponse));
      if (moviesData.has("Search")) {
        JSONArray searchArray = moviesData.getJSONArray("Search");
        List<Map<String, String>> movieList = new ArrayList<>();

        for (int i = 0; i < searchArray.length(); i++) {
          JSONObject movieData = searchArray.getJSONObject(i);
          Map<String, String> movieDetails = new HashMap<>();
          movieDetails.put("Title", movieData.optString("Title"));
          movieDetails.put("Year", movieData.optString("Year"));
          movieDetails.put("Genre", movieData.optString("Genre"));
          movieDetails.put("imdbRating", movieData.optString("imdbRating"));
          movieDetails.put("Poster", movieData.optString("Poster"));
          movieList.add(movieDetails);
        }
        // System.out.println(movieList);
      }


      // }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }



  }
}
