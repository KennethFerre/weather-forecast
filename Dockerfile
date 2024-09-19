# Etapa 1: Compilacion del proyecto
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y resolver dependencias
COPY pom.xml .

# Descargar las dependencias sin compilar aun el proyecto
RUN mvn dependency:go-offline

# Copiar el codigo fuente
COPY src ./src

# Compilar el proyecto y empaquetarlo
RUN mvn clean package

# Etapa 2: Imagen final con el JAR empaquetado
FROM eclipse-temurin:17-jre-alpine

# Crear un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/weather-forecast-0.0.1.jar /app/weather-forecast.jar

# Exponer el puerto que usa la aplicacion
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "weather-forecast.jar"]