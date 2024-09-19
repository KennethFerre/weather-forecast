package com.weatherapi.forecast.application.services;

import com.weatherapi.forecast.application.dto.prevision.PrevisionDiaResponse;
import com.weatherapi.forecast.shared.domain.ports.in.SearchPrevisionMunicipioUseCase;
import com.weatherapi.forecast.shared.domain.ports.out.PrevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class PrevisionService implements SearchPrevisionMunicipioUseCase {

    private final PrevisionRepository previsionRepository;

    public PrevisionService(PrevisionRepository previsionRepository) {
        this.previsionRepository = previsionRepository;
    }

    @Override
    public PrevisionDiaResponse buscarPrevisionMunicipio(String id, String unidades) {
        return this.previsionRepository.buscarPrevisionMunicipio(id, unidades);
    }

}