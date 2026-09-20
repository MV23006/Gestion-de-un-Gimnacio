# Etapa 1: Construcción (Build)
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiar archivos de Gradle para aprovechar la caché de capas
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Dar permisos de ejecución e instalar dependencias
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon

# Copiar el código fuente y compilar
COPY src src
RUN ./gradlew bootJar --no-daemon -x test

# Etapa 2: Imagen final para ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el ejecutable .jar generado
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]