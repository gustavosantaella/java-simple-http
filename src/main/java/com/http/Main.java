package com.http;

import java.util.Map;

import com.http.request.Request;
import com.http.request.Response;

public class Main {
    public static void main(String[] args) {
        Request req = new Request(args[0]);

        try {
            Response data = req.get();
            System.out.println(data);
        } catch (Exception e) {
            // Handle the exception
            System.out.println("An error ocurred on Main class " + e.toString());
        }

        System.out.println("Method has been finished :D");
    }
}
