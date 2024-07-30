package com.ajayghimire.imdbMovies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class IMDBMovieDAO {


  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("http://www.omdbapi.com/?t=batman&apikey=1f4503a2")).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    System.out.println(response.body());

  }
}
