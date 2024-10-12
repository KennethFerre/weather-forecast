package com.weatherapi.forecast.infrastructure.adapters.rest.out;

import com.weatherapi.forecast.shared.exception.AemetException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AemetRestClient {

    private final RestTemplate aemetRestTemplate;

    public AemetRestClient(RestTemplate restTemplate) {
        this.aemetRestTemplate = restTemplate;
    }

    public <T> T get(String url, Class<T> responseType) {
        final HttpEntity<String> entity = new HttpEntity<>("body");
        ResponseEntity<T> responseEntity = aemetRestTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        return responseEntity.getBody();
    }

    public <T> T get(String url, ParameterizedTypeReference<T> parameterizedTypeReference) {
        final HttpEntity<String> entity = new HttpEntity<>("body");
        try {
            ResponseEntity<T> responseEntity = aemetRestTemplate.exchange(url, HttpMethod.GET, entity, parameterizedTypeReference);
            return responseEntity.getBody();

        } catch (Exception exception) {
            throw new AemetException(exception.getMessage(), url, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}