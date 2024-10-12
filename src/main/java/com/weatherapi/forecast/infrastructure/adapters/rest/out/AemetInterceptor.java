package com.weatherapi.forecast.infrastructure.adapters.rest.out;

import com.weatherapi.forecast.configuration.AemetProperties;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AemetInterceptor implements ClientHttpRequestInterceptor {

    private final AemetProperties aemetProperties;
    private final List<String> aemetAuthUrls;

    public AemetInterceptor(AemetProperties aemetProperties) {
        this.aemetProperties = aemetProperties;
        this.aemetAuthUrls = List.of(
            aemetProperties.getPathMunicipios(),
            aemetProperties.getPathPrediccionHorariaMunicipio()
        );
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (requiresAuth(request.getURI().toString())) {
            request.getHeaders().setBearerAuth(aemetProperties.getToken());
        }
        return execution.execute(request, body);
    }

    private boolean requiresAuth(String requestUrl) {
        return aemetAuthUrls.stream().anyMatch(requestUrl::contains);
    }
}
