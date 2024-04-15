FROM ubuntu:latest AS build

RUN apt-get update \
    && apt-get install -y openjdk-17-jdk maven \
    && apt-get clean

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8081

COPY --from=build /app/target/DigitalBank-0.0.1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
