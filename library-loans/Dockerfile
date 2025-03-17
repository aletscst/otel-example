ARG LIBRARY_USERS_URL_BASE
ARG LIBRARY_BOOKS_URL_BASE

ARG MYSQL_HOST
ARG OTEL_EXPORTER_OTLP_ENDPOINT
ARG API_TOKEN

FROM maven:3.9.7-eclipse-temurin-21 as maven_build

WORKDIR /commons/
COPY library-commons .
RUN mvn clean install -DskipTests

WORKDIR /
COPY library-loans/pom.xml .
COPY library-loans/src ./src

# Build
RUN mvn -DskipTests=true clean package

# Deploy
FROM eclipse-temurin:21-jre-jammy
ENV TZ="America/Mexico_City"

ENV MYSQL_HOST=$MYSQL_HOST

ENV LIBRARY_USERS_URL_BASE=$LIBRARY_USERS_URL_BASE
ENV LIBRARY_BOOKS_URL_BASE=$LIBRARY_BOOKS_URL_BASE

ENV OTEL_EXPORTER_OTLP_ENDPOINT=$OTEL_EXPORTER_OTLP_ENDPOINT
ENV OTEL_JAVAAGENT_LOGGING="application"
ENV OTEL_SERVICE_NAME="library-loans"
ENV OTEL_EXPORTER_OTLP_HEADERS="Authorization=Bearer api-token-here"

COPY --from=maven_build /target/*.jar ./
COPY --from=maven_build /src/main/resources/opentelemetry-javaagent.jar ./

ENTRYPOINT ["java","-javaagent:opentelemetry-javaagent.jar","-jar","/library-loans-0.0.1-SNAPSHOT.jar"]