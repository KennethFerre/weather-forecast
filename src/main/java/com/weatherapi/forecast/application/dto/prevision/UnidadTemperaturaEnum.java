package com.weatherapi.forecast.application.dto.prevision;

public enum UnidadTemperaturaEnum {
    G_CEL,
    G_FAH;

    public static UnidadTemperaturaEnum fromString(String value) {
        try {
            return UnidadTemperaturaEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return G_CEL;
        }
    }
}