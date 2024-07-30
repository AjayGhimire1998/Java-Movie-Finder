package com.ajayghimire.imdbMovies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class IMDBMovieDAO {
  private static final String API_KEY = "1f4503a2";


  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException {
    String apiUrlBuilder =
        String.format("http://www.omdbapi.com/?t=%s&apikey=%s", "batman", API_KEY);

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(apiUrlBuilder)).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


      System.out.println(response.body());
      // }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

  }
}
