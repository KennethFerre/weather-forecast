package com.weatherapi.forecast.configuration;

import com.weatherapi.forecast.infrastructure.adapters.rest.out.AemetInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

@Configuration
public class AemetRestTemplateConfig {

    private final AemetInterceptor aemetInterceptor;

    public AemetRestTemplateConfig(AemetInterceptor aemetInterceptor) {
        this.aemetInterceptor = aemetInterceptor;
    }

    @Bean
    public RestTemplate aemetRestTemplate() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        converter.setDefaultCharset(Charset.forName("ISO-8859-15"));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(converter);
        restTemplate.setInterceptors(List.of(aemetInterceptor));
        return restTemplate;
    }

}