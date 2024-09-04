FROM amazoncorretto:17-alpine as build

WORKDIR /app

COPY . .

RUN ./gradlew assemble

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/cardap.io-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]