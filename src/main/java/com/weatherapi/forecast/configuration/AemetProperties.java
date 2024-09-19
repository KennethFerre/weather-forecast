package com.weatherapi.forecast.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aemet.api")
@Getter
@Setter
public class AemetProperties {

    private String urlBase;
    private String pathPrediccionHorariaMunicipio;
    private String pathMunicipios;
    private String token;
}