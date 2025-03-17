# OpenTelemetry Ejemplo

Este pryecto tiene como finalidad mostrar un uso basico de `OpenTelemetry` usando el javaagent proporcionado en su [documentacion](https://opentelemetry.io/docs/zero-code/java/agent/)

## Estructura

### APIS
![java-apis](/docs-resources/images/java-apis.png)

* `library`: Consulta a las demas api para englobal las consultas

* `library-users`: Provee el CRUD de los usuarios

* `library-books`: Provee el CRUD de los libros

* `library-loans`: Provee el CRUD de los los prestamos y consulta a `library-users` y `library-books` para informacion adicional

* `library-commons`: provee los dto, Entidades, Excepciones y utilidades que comparten las demas API's

### Observabilidad

![alt text](/docs-resources/images/observability.png)

En el diagrama se muestra de manera general el funcionamiento de la telemetria con un javaagent y el otelCollector usando herramientas para los pilares de la observabilidad

* Loki -> Logs
* Prometheus -> telemetria
* Tempo-> Trazabilidad

Sin olvidar a Grafana como herramienta de visualización

## Build

### Telemetry

En la carpeta builders se encuentran dos subcarpetas que contienen:
1. **telemetry**: Contiene toda la configuración de las herramientas de telemetria

### Database

Para que las apis funcionen se conectan a una base de datos MySQL llamada library, puedes ejecutar el script de la carpeta database para crearla con datos por default

### Application

2. **library-application**: Contiene el docker-componse que levanta todas las apis mostradas en el [diagrama de apis](#apis)

> [!NOTE]
> Revisar los ARG dentro del archico docker.env para evitar fallas