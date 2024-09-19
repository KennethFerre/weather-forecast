package com.weatherapi.forecast.shared.utils;

public class MunicipioUtils {

    private static final String PREFIJO_MUNICIPIO_ID = "id";

    private MunicipioUtils() { /*No se implementa*/  }

    public static String obtenerCodigoMunicipio(String id) {
        return id.replace(PREFIJO_MUNICIPIO_ID, "");
    }
}