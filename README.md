# Spring Boot Application

## Descripción

Esta es una aplicación basada en **Spring Boot** para consultar la previsión climatológica en cualquier municipio de España vía API de AEMET.

## Requisitos

Antes de comenzar, asegúrate de tener los siguientes requisitos instalados en tu sistema:

- **Java JDK 17** o superior.
- **Maven** 
- **Git** (opcional, si deseas clonar el repositorio directamente).

## Instalación

### 1. Clonar el repositorio

Si estás utilizando Git, puedes clonar este repositorio ejecutando:

```bash
git clone https://github.com/KennethFerre/weather-forecast.git
cd weather-forecast
```

### 2. Compilar

Puedes compilar con Maven ejecutando:

```bash
mvn clean install
```

### 3. Ejecutar 
```bash
mvn spring-boot:run
```
Alternativamente, puedes ejecutar el archivo ***.jar*** directamente.
```bash
java -jar target/weather-forecast-0.0.1-SNAPSHOT.jar
```

### 4. Pruebas
Importar la colección de Postman(weather-forecast.postman_collection.json) que adjunto en el email de entrega.


Alternativamente, accediendo desde el navegador para consultar los municipios:
```bash
http://localhost:8080/api/municipios
```
Consultar previsión por municipio
```bash
http://localhost:8080/api/prevision/municipio?id=id40001&unidad=G_FAH
```


