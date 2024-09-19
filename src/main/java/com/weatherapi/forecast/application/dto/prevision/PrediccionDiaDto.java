package com.weatherapi.forecast.application.dto.prevision;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PrediccionDiaDto {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha;

    private String nombreMunicipio;
    List<PrevisionDetalladaDto> estadoCielo;
    List<PrevisionBasicaDto> probPrecipitacion;
    List<PrevisionBasicaDto> temperatura;

}