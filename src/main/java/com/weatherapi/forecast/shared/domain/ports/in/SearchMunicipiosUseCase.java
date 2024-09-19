package com.weatherapi.forecast.shared.domain.ports.in;

import com.weatherapi.forecast.application.dto.MunicipioDto;

import java.util.List;

public interface SearchMunicipiosUseCase {
    List<MunicipioDto> buscarMunicipios();
}