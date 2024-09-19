package com.weatherapi.forecast.application.services;

import com.weatherapi.forecast.application.dto.MunicipioDto;
import com.weatherapi.forecast.shared.domain.ports.in.SearchMunicipiosUseCase;
import com.weatherapi.forecast.shared.domain.ports.out.MunicipiosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService implements SearchMunicipiosUseCase {

    private final MunicipiosRepository municipiosRepository;

    public MunicipioService(MunicipiosRepository municipiosRepository) {
        this.municipiosRepository = municipiosRepository;
    }

    @Override
    public List<MunicipioDto> buscarMunicipios() {
        return this.municipiosRepository.buscarMunicipios();
    }

}