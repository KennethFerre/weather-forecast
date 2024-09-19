package com.weatherapi.forecast.shared.utils;

import org.springframework.web.util.UriComponentsBuilder;

public class UtilsUri {
    private UtilsUri() { /*No se implementa*/ }

    public static String buildUrl(String baseUrl, String path) {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(path)
                .toUriString();
    }

    public static String buildPathSegment(String baseUrl, String pathSegment) {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .pathSegment(pathSegment)
                .toUriString();
    }

}