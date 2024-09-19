package com.weatherapi.forecast.application.dto.responses;

import com.weatherapi.forecast.application.dto.MunicipioDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MunicipiosResponseDto {
    private List<MunicipioDto> municipios;
}