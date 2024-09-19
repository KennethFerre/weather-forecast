package com.weatherapi.forecast.application.dto.prevision;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrevisionBasicaDto {
    private String value;
    private String periodo;
}