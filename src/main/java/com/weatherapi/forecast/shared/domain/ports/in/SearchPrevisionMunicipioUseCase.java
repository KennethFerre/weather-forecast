package com.weatherapi.forecast.shared.domain.ports.in;

import com.weatherapi.forecast.application.dto.prevision.PrevisionDiaResponse;

public interface SearchPrevisionMunicipioUseCase {
    PrevisionDiaResponse buscarPrevisionMunicipio(String id, String unidades);
}