package com.weatherapi.forecast.shared.domain.ports.out;

import com.weatherapi.forecast.application.dto.MunicipioDto;

import java.util.List;

public interface MunicipiosRepository {
    List<MunicipioDto> buscarMunicipios();
}