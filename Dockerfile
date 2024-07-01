FROM eclipse-temurin:17-jdk-jammy as build-image
WORKDIR /to-build-app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY . .
RUN ./mvnw clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
