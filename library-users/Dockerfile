# Build
FROM maven:3.9.7-eclipse-temurin-21 as maven_build

WORKDIR /

COPY pom.xml .
COPY src ./src

RUN mvn -DskipTests=true clean package

# Deploy
FROM eclipse-temurin:21-jre-jammy
ENV TZ="America/Mexico_City"

ENV MYSQL_HOST="host.docker.internal:3306"

ENV OTEL_EXPORTER_OTLP_ENDPOINT="http://host.docker.internal:4318"
ENV OTEL_JAVAAGENT_LOGGING="application"
ENV OTEL_SERVICE_NAME="library-users"

COPY --from=maven_build /target/*.jar ./
COPY --from=maven_build /src/main/resources/opentelemetry-javaagent.jar ./

ENTRYPOINT ["java","-javaagent:opentelemetry-javaagent.jar","-jar","/library-users-0.0.1-SNAPSHOT.jar"]