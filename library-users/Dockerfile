ARG MYSQL_HOST
ARG OTEL_EXPORTER_OTLP_ENDPOINT
ARG API_TOKEN

FROM maven:3.9.7-eclipse-temurin-21 as maven_build

WORKDIR /commons/
COPY library-commons .
RUN mvn clean install -DskipTests

WORKDIR /
COPY library-users/pom.xml .
COPY library-users/src ./src

# Build
RUN mvn -DskipTests=true clean package

# Deploy
FROM eclipse-temurin:21-jre-jammy
ENV TZ="America/Mexico_City"

ENV MYSQL_HOST="$MYSQL_HOST"

ENV OTEL_EXPORTER_OTLP_ENDPOINT=$OTEL_EXPORTER_OTLP_ENDPOINT
ENV OTEL_JAVAAGENT_LOGGING="application"
ENV OTEL_SERVICE_NAME="library-users"
ENV OTEL_EXPORTER_OTLP_HEADERS="Authorization=Bearer api-token-here"

COPY --from=maven_build /target/*.jar ./
COPY --from=maven_build /src/main/resources/opentelemetry-javaagent.jar ./

ENTRYPOINT ["java","-javaagent:opentelemetry-javaagent.jar","-jar","/library-users-0.0.1-SNAPSHOT.jar"]