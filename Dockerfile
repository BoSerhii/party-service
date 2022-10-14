FROM openjdk:17-jdk-slim-bullseye
RUN mkdir /app
COPY ./target/party-service-0.0.1-SNAPSHOT.jar /app/party-service.jar
WORKDIR /app
CMD "java" "-jar" "/app/party-service.jar"