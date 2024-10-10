# Use uma imagem base do Java
FROM openjdk:19-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado pela build
COPY target/restaurantes-api-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]