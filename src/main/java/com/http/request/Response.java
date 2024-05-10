package com.http.request;

import java.util.HashMap;

public class Response {
    private String data = "";
    private Integer statusCode;

    public Response(String data, Integer statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public HashMap<String, Object> getData() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", this.data);
        map.put("statusCode", this.statusCode);

        return map;
    }

}
