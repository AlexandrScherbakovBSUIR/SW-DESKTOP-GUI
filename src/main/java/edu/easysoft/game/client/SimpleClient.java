package edu.easysoft.game.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.concurrent.Flow;

public class SimpleClient {

    public String getRequest(String url) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest getRequest = null;
        try {
            getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<String> response = null;
        try {
            response = client.send(getRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("request: "+ url);
        System.out.println("response code: " + response.statusCode());
        return response.body() ;
    }


    public String postRequest(String url,String jsonString) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest postRequest = null;

        try {
            postRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<String> response = null;
        try {
            response = client.send(postRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("request: "+ url);
        System.out.println("response code: " + response.statusCode());
        return response.body() ;
    }

}

