package com.http.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.util.HashMap;
import java.util.Map;

public class Request {

    URI uri;
    HttpClient client;
    Builder builder;

    public static void main(String[] args) {
        Request r = new Request(args[0]);

        try {
            System.out.println(r.get().toString());
        } catch (Exception e) {
            System.out.println("An error ocurred");
            System.out.println(e.toString());
        }

    }

    public Request(String uri) {
        this.uri = URI.create(uri);

        client = HttpClient.newHttpClient();
        builder = HttpRequest
                .newBuilder().uri(this.uri);
    }

    public Request setHeader(String key, String value) throws Exception {
        builder.header(key, value);
        return this;
    }

    public Map<String, Object> get() throws Exception {
        try {

            HttpRequest request = builder.GET()
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", response.body());
            map.put("statusCode", response.statusCode());
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    public Map<String, Object> post(HashMap<String, Object> data) throws Exception {
        try {

            HttpRequest request = builder.POST(BodyPublishers.ofString(data.toString()))
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", response.body());
            map.put("statusCode", response.statusCode());
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    public Map<String, Object> put(HashMap<String, Object> data) throws Exception, IOException, InterruptedException {
        try {

            HttpRequest request = builder.PUT(BodyPublishers.ofString(data.toString()))
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", response.body());
            map.put("statusCode", response.statusCode());
            return map;
        } catch (Exception e) {
            throw e;
        }
    }
}
