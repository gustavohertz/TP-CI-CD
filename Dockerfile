# ETAPA 3: Dockerfile simples (não multi-stage)

# Pré-requisito: Você DEVE ter o 'target/devcalc-api-1.0.0.jar' construído localmente
# Execute 'mvn clean package' ANTES de construir esta imagem.

# 1. Imagem base
# Usamos uma imagem JRE (Java Runtime Environment) slim, pois só precisamos executar o .jar
FROM openjdk:11-jre-slim

# 2. Define o diretório de trabalho
WORKDIR /main

# 3. Copia o "fat jar" (construído localmente) para dentro da imagem
COPY target/devcalc-api-1.0.0.jar /app/app.jar

# 4. Expõe a porta que o Javalin usa
EXPOSE 7070

# 5. Comando para executar a aplicação quando o container iniciar
CMD ["java", "-jar", "/app/app.jar"]