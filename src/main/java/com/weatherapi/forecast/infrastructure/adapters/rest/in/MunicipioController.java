package com.weatherapi.forecast.infrastructure.adapters.rest.in;

import com.weatherapi.forecast.application.dto.MunicipioDto;
import com.weatherapi.forecast.shared.domain.ports.in.SearchMunicipiosUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MunicipioController {
    private final SearchMunicipiosUseCase searchMunicipiosUseCase;

    public MunicipioController(SearchMunicipiosUseCase searchMunicipiosUseCase) {
        this.searchMunicipiosUseCase = searchMunicipiosUseCase;
    }

    @GetMapping("/municipios")
    public ResponseEntity<List<MunicipioDto>> buscarMunicipios() {
        return ResponseEntity.ok(searchMunicipiosUseCase.buscarMunicipios());
    }

}