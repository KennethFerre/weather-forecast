package com.weatherapi.forecast.infrastructure.adapters.rest.in;

import com.weatherapi.forecast.application.dto.prevision.PrevisionDiaResponse;
import com.weatherapi.forecast.shared.domain.ports.in.SearchPrevisionMunicipioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prevision")
public class PrevisionMeteorologicaController {
    private final SearchPrevisionMunicipioUseCase searchPrevisionMunicipioUseCase;

    public PrevisionMeteorologicaController(SearchPrevisionMunicipioUseCase searchPrevisionMunicipioUseCase) {
        this.searchPrevisionMunicipioUseCase = searchPrevisionMunicipioUseCase;
    }

    @GetMapping("/municipio")
    public ResponseEntity<PrevisionDiaResponse> buscarMunicipiosPorNombre(@RequestParam String id, @RequestParam(defaultValue = "G_CEL") String unidad) {
        return ResponseEntity.ok(searchPrevisionMunicipioUseCase.buscarPrevisionMunicipio(id, unidad));
    }

}