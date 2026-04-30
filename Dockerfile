# Estágio 1: Build (Compilação) usando Gradle 7.6
FROM gradle:7.6-jdk17 AS build
WORKDIR /app
COPY . .
# Forçamos o uso do Gradle da imagem (7.6) em vez do wrapper do projeto
RUN gradle build -x test --no-daemon

# Estágio 2: Run (Execução)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
