package com.weatherapi.forecast.application.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AemetResponse {
    private String descripcion;
    private Integer estado;
    private String datos;
    private String metadatos;
}