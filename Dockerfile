FROM openjdk:17

WORKDIR /app

# Copia o arquivo JAR do diretório local para o diretório /app no contêiner
COPY ./target/ATJAVA-0.0.1-SNAPSHOT.jar /app/app.jar

# Comando para executar o arquivo JAR quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
