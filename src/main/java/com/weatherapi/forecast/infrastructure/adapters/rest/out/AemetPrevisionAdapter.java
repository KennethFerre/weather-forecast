package com.weatherapi.forecast.infrastructure.adapters.rest.out;

import com.weatherapi.forecast.application.dto.prevision.PrediccionMunicipioDto;
import com.weatherapi.forecast.application.dto.prevision.PrevisionDiaResponse;
import com.weatherapi.forecast.application.dto.prevision.UnidadTemperaturaEnum;
import com.weatherapi.forecast.application.dto.responses.AemetResponse;
import com.weatherapi.forecast.configuration.AemetProperties;
import com.weatherapi.forecast.shared.domain.ports.out.PrevisionRepository;
import com.weatherapi.forecast.shared.exception.MunicipioNotFoundException;
import com.weatherapi.forecast.shared.utils.MunicipioUtils;
import com.weatherapi.forecast.shared.utils.HeaderUtils;
import com.weatherapi.forecast.shared.utils.PrevisionUtils;
import com.weatherapi.forecast.shared.utils.UtilsUri;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AemetPrevisionAdapter implements PrevisionRepository {

    private final AemetProperties aemetProperties;
    private final AemetRestClient aemetRestClient;

    public AemetPrevisionAdapter(AemetProperties aemetProperties, AemetRestClient aemetRestClient) {
        this.aemetProperties = aemetProperties;
        this.aemetRestClient = aemetRestClient;
    }

    @Override
    public PrevisionDiaResponse buscarPrevisionMunicipio(String id, String unidades) {
        String baseUrlPrediccion = UtilsUri.buildUrl(aemetProperties.getUrlBase(), aemetProperties.getPathPrediccionHorariaMunicipio());
        final String urlPrediccion = UtilsUri.buildPathSegment(baseUrlPrediccion, MunicipioUtils.obtenerCodigoMunicipio(id));
        HttpHeaders headers = HeaderUtils.getHeaders(aemetProperties.getToken());

        AemetResponse aemetResponse = aemetRestClient.get(urlPrediccion, AemetResponse.class, headers);

        if (aemetResponse.getDatos() == null)
            throw new MunicipioNotFoundException(String.format("No se ha encontrado la previsión para el municipio con código %s", id), HttpStatus.NOT_FOUND);

        List<PrediccionMunicipioDto> municipioResponse = this.aemetRestClient.get(
            aemetResponse.getDatos(),
            HeaderUtils.getHeaders(),
            new ParameterizedTypeReference<>() {}
        );

        return PrevisionUtils.convertPredicion(
            Objects.requireNonNull(municipioResponse).get(0),
            UnidadTemperaturaEnum.fromString(unidades)
        );
    }

}