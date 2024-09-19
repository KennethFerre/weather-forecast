package com.weatherapi.forecast.infrastructure.adapters.rest.out;

import com.weatherapi.forecast.application.dto.MunicipioDto;
import com.weatherapi.forecast.application.dto.responses.AemetResponse;
import com.weatherapi.forecast.configuration.AemetProperties;
import com.weatherapi.forecast.shared.domain.ports.out.MunicipiosRepository;
import com.weatherapi.forecast.shared.exception.AemetException;
import com.weatherapi.forecast.shared.utils.HeaderUtils;
import com.weatherapi.forecast.shared.utils.UtilsUri;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AemetMunicipiosAdapter implements MunicipiosRepository {

    private final AemetProperties aemetProperties;
    private final AemetRestClient aemetRestClient;

    public AemetMunicipiosAdapter(AemetProperties aemetProperties, AemetRestClient aemetRestClient) {
        this.aemetProperties = aemetProperties;
        this.aemetRestClient = aemetRestClient;
    }

    @Override
    public List<MunicipioDto> buscarMunicipios() {
        final String endpoint = UtilsUri.buildUrl(aemetProperties.getUrlBase(), aemetProperties.getPathMunicipios());
        AemetResponse aemetResponse = this.aemetRestClient.get(
            endpoint,
            AemetResponse.class,
            HeaderUtils.getHeaders(aemetProperties.getToken())
        );

        if (aemetResponse.getDatos() == null)
            throw new AemetException("No se encontraron municipios", endpoint, HttpStatus.NOT_FOUND);

        return this.aemetRestClient.get(
            aemetResponse.getDatos(),
            HeaderUtils.getHeaders(),
            new ParameterizedTypeReference<>() {}
        );
    }

}