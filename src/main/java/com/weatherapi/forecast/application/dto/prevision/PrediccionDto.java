package com.weatherapi.forecast.application.dto.prevision;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrediccionDto {
    List<PrediccionDiaDto> dia;
}