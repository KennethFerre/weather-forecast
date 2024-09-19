package com.weatherapi.forecast.application.dto.prevision;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrevisionDetalladaDto extends PrevisionBasicaDto {
    private String descripcion;

    PrevisionDetalladaDto(String value, String periodo, String descripcion) {
        super(value, periodo);
        this.descripcion = descripcion;
    }
}
