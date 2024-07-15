FROM maven:3.8.1-openjdk-11 as build

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:11

WORKDIR /app

COPY --from=build /app/target/beach-product-rental-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]