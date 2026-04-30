# Estágio 1: Build (Compilação usando Gradle)
FROM gradle:7.6-jdk17 AS build
WORKDIR /app

# Copia os arquivos de configuração do Gradle primeiro para aproveitar o cache
COPY build.gradle settings.gradle ./
COPY src ./src

# Executa o build do projeto gerando o arquivo JAR
RUN gradle clean bootJar --no-daemon

# Estágio 2: Run (Execução em imagem leve)
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado no estágio anterior (no Gradle, ele fica na pasta build/libs)
COPY --from=build /app/build/libs/*.jar app.jar

# Porta configurada no seu application.properties
EXPOSE 8081

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
