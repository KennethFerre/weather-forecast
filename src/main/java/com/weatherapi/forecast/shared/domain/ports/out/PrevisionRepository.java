package com.weatherapi.forecast.shared.domain.ports.out;

import com.weatherapi.forecast.application.dto.prevision.PrevisionDiaResponse;

public interface PrevisionRepository {
    PrevisionDiaResponse buscarPrevisionMunicipio(String id, String unidades);
}