package com.weatherapi.forecast.shared.utils;

import org.springframework.http.HttpHeaders;

public class HeaderUtils {

    private HeaderUtils() { /*No se implementa*/ }

    public static HttpHeaders getHeaders(String apiToken) {
        HttpHeaders headers = getHeaders();
        headers.setBearerAuth(apiToken);
        return headers;
    }

    public static HttpHeaders getHeaders() {
        return new HttpHeaders();
    }

}