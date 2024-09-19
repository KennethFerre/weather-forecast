package com.weatherapi.forecast.application.dto.prevision;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PrevisionDiaResponse {
    private String nombreMunicipio;
    private LocalDate fecha;
    private Float mediaTemperatura;
    String estadoCielo;
    private UnidadTemperaturaEnum unidadTemperatura;
    private List<ProbabilidadPrecipitacion> probPrecipitacion;
}