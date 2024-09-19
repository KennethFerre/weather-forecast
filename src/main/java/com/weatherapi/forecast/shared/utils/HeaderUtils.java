package com.weatherapi.forecast.shared.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HeaderUtils {

    private HeaderUtils() { /*No se implementa*/ }

    public static HttpHeaders generarCabeceraAcceptJson(String apiToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.setBearerAuth(apiToken);
        return headers;
    }

    public static HttpHeaders generarCabeceraAcceptJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}