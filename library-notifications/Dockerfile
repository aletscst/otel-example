ARG OTEL_EXPORTER_OTLP_ENDPOINT

# Build Stage
FROM node:20-alpine AS build
ARG OTEL_EXPORTER_OTLP_ENDPOINT

ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=true

WORKDIR /usr/src/app

COPY /library-notifications/package*.json ./
COPY /library-notifications/tsconfig.json ./
COPY /library-notifications/*.env ./

RUN npm install

COPY . .

RUN npm run build

# Runtime Stage
FROM node:20-alpine AS runtime
ARG OTEL_EXPORTER_OTLP_ENDPOINT

WORKDIR /usr/src/app

RUN apk add --no-cache chromium

COPY --from=build /usr/src/app/dist ./dist
COPY --from=build /usr/src/app/node_modules ./node_modules

ENV NODE_ENV=production
ENV CHROME_BIN=/usr/bin/chromium-browser

ENV PORT=3700

# OpenTelemetry
ENV OTEL_SERVICE_NAME=library-notifications
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=otlp
ENV OTEL_LOGS_EXPORTER=otlp
ENV OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://host.docker.internal:4318
ENV OTEL_HEADER_AUTH=api-token-here

CMD ["node", "--require", "./dist/config/instrumentations.config.js", "dist/index.js"]
