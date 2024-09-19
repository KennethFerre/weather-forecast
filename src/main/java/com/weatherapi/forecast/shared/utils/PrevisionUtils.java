package com.weatherapi.forecast.shared.utils;

import com.weatherapi.forecast.application.dto.prevision.*;
import com.weatherapi.forecast.shared.exception.AemetException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class PrevisionUtils {

    public PrevisionUtils() { /*No se implementa*/ }

    public static PrevisionDiaResponse convertPredicion(PrediccionMunicipioDto prediccionesMunicipioDto, UnidadTemperaturaEnum temperaturaEnum) {
        LocalDate fechaSiguiente = LocalDate.now().plusDays(1);
        PrediccionDiaDto prediccionDiaActualDto = prediccionesMunicipioDto.getPrediccion().getDia()
            .stream()
            .filter(prediccionDiaDto ->  prediccionDiaDto.getFecha().toLocalDate().equals(fechaSiguiente))
            .findFirst().orElseThrow(() -> {
                throw new AemetException(String.format("No se han obtenido predicciones para el municipio %s", prediccionesMunicipioDto.getNombre()), HttpStatus.NOT_FOUND);
            });

        float temperaturaMedia = calcularMedia(prediccionDiaActualDto.getTemperatura());
        if (UnidadTemperaturaEnum.G_FAH.equals(temperaturaEnum))
            temperaturaMedia = celsiusToFahrenheit(temperaturaMedia);

        List<ProbabilidadPrecipitacion> probabilidadPrecipitacionList = prediccionDiaActualDto.getProbPrecipitacion()
                .stream()
                .map(prov -> ProbabilidadPrecipitacion.builder().periodo(prov.getPeriodo()).probabilidad(prov.getValue()).build())
                .toList();

        String estadoCielo = obtenerEstadoCieloActual(prediccionDiaActualDto.getEstadoCielo());

        return PrevisionDiaResponse.builder()
                .nombreMunicipio(prediccionesMunicipioDto.getNombre())
                .fecha(prediccionDiaActualDto.getFecha().toLocalDate())
                .unidadTemperatura(temperaturaEnum)
                .mediaTemperatura(temperaturaMedia)
                .estadoCielo(estadoCielo)
                .probPrecipitacion(probabilidadPrecipitacionList)
                .build();
    }

    private static float calcularMedia(List<PrevisionBasicaDto> temperatura) {
        return  (float) temperatura.stream()
                .mapToInt((tmp) -> Integer.parseInt(tmp.getValue()))
                .average()
                .orElseThrow(() -> new AemetException("No se puede calcular la media.", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private static String obtenerEstadoCieloActual(List<PrevisionDetalladaDto> estadosCielo) {
        String horaActual = obtenerHoraActual();
        Optional<String> valorCielo =  estadosCielo.stream()
                .filter(estado -> horaActual.equals(estado.getPeriodo()))
                .map(PrevisionDetalladaDto::getValue)
                .findFirst();
        return valorCielo.orElse("");
    }

    private static String obtenerHoraActual() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH"));
    }

    private static float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

}