# Estágio 1: Build com Gradle
FROM gradle:7.6-jdk17 AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Estágio 2: Execução com Java 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Ajuste o nome do .jar abaixo se o seu projeto tiver outro nome no build/libs
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
