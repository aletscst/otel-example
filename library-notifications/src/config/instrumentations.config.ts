import * as opentelemetry from '@opentelemetry/sdk-node';
import { getNodeAutoInstrumentations } from '@opentelemetry/auto-instrumentations-node';
import { OTLPTraceExporter } from '@opentelemetry/exporter-trace-otlp-proto';
import { OTLPMetricExporter } from '@opentelemetry/exporter-metrics-otlp-proto';
import { OTLPLogExporter } from '@opentelemetry/exporter-logs-otlp-proto';
import { PeriodicExportingMetricReader } from '@opentelemetry/sdk-metrics';
import { SimpleLogRecordProcessor } from '@opentelemetry/sdk-logs';

const OTEL_EXPORTER_OTLP_ENDPOINT = process.env.OTEL_EXPORTER_OTLP_ENDPOINT || 'http://localhost:4318';

export const sdkAutoInstrumentations = new opentelemetry.NodeSDK({
  traceExporter: new OTLPTraceExporter({
    // optional - default url is http://localhost:4318/v1/traces
    url: `${OTEL_EXPORTER_OTLP_ENDPOINT}/v1/traces`,
    // optional - collection of custom headers to be sent with each request, empty by default
    headers: {
      'Authorization': `Bearer ${process.env.OTEL_HEADER_AUTH}`,
    },
  }),
  metricReader: new PeriodicExportingMetricReader({
    exporter: new OTLPMetricExporter({
      url: `${OTEL_EXPORTER_OTLP_ENDPOINT}/v1/metrics`,// url is optional and can be omitted - default is http://localhost:4318/v1/metrics
      headers: {
        'Authorization': `Bearer ${process.env.OTEL_HEADER_AUTH}`,
      }, // an optional object containing custom headers to be sent with each request
    }),
  }),
  logRecordProcessors: [
    new SimpleLogRecordProcessor(new OTLPLogExporter({
      url: `${OTEL_EXPORTER_OTLP_ENDPOINT}/v1/logs`,
      headers: {
        'Authorization': `Bearer ${process.env.OTEL_HEADER_AUTH}`,
      },
    }))
  ],
  instrumentations: [getNodeAutoInstrumentations()],
});

sdkAutoInstrumentations.start();