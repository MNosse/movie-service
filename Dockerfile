FROM gradle:8.2.1-jdk17 AS build

COPY . /movie-web-service

WORKDIR /movie-web-service

RUN gradle clean build

FROM openjdk:17

COPY --from=build /movie-web-service/build/libs/movie-service-0.0.1-SNAPSHOT.jar /app/movie-web-service.jar

WORKDIR /app

CMD ["java", "-jar", "movie-web-service.jar"]