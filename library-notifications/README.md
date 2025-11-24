# AMMFEC Notifications

AMMFEC Notifications es un servicio de notificaciones desarrollado en **Node.js** que permite el envío de mensajes a través de **WhatsApp, Telegram y correo electrónico**.

## Características
- Envío de mensajes por **WhatsApp**.
- Envío de mensajes por **Telegram**.
- Envío de notificaciones por **correo electrónico**.
- Integración sencilla mediante API REST.
- Configurable y extensible.

## Requisitos

Para ejecutar este proyecto necesitas tener instalado:
- [Node.js](https://nodejs.org/) (v22.11 o superior)
- [Typescript](https://www.typescriptlang.org/)
- [npm](https://www.npmjs.com/)

## Instalación

Clona el repositorio e instala las dependencias:

```sh
# Clonar el repositorio
git clone https://github.com/usuario/ammfec-notifications.git
cd ammfec-notifications

# Instalar dependencias
npm install
```

## Configuración

El proyecto utiliza variables de entorno para la configuración. Crea un archivo `.env` en la raíz del proyecto con los siguientes valores:

```env
PORT=3200

DB_HOST=localhost
DB_PORT=3506
DB_USER_NAME=user
DB_USER_PSW=password
DB_CLIENTS_NAME=db_clients
DB_XIPATLANI_NAME=db_xipatlani

API_KEY='apikey'
CORS_ALLOW_ORIGINS='domain1.com; domain2.com'

TELEGRAM_BOT_KEY='telegram_bot_key'

SMTP_NAME='www.domain.com'
SMTP_HOST='host.domain.com'
SMTP_PORT=465
SMTP_USER='email@domain'
SMTP_PASS='password'
```

## Uso

### Iniciar el servidor

```sh
npm run dev
```

### Envio de notificaciones

#### WhatsApp

Ejemplo de solicitud **POST** para enviar una notificación:

```sh
curl --location 'http://localhost:3200/whatsapp/send-message' \
--header 'App-key-use: apikey' \
--header 'Content-Type: application/json' \
--data '{
    "phone":"+5255 7067 5356",
    "message":"Mensaje de prueba para validar codigo"
}'
```

### Respuesta esperada

```json
{
  "status": 200,
  "message": "Mensaje enviado con éxito"
}
```

#### Telegram

Ejemplo de solicitud **POST** para enviar una notificación:

```sh
curl --location 'http://localhost:3200/telegram/send-message-group' \
--header 'App-key-use: apikey' \
--header 'Content-Type: application/json' \
--data '{
    "chatName":"PURCHASE_NOTIFICATIONS",
    "message":"Mensaje de prueba para *API NOTIFICATIONS*"
}'
```

### Respuesta esperada

```json
{
  "status": 200,
  "message": "Mensaje enviado con éxito"
}
```

#### Mail

Ejemplo de solicitud **POST** para enviar una notificación:

```sh
curl --location 'http://localhost:3200/mail/send-mail' \
--header 'App-key-use: apikey' \
--header 'Content-Type: application/json' \
--data '{
    "to": "mail1@example.com; mail2@example.com",
    "cc":"mail3@example.com",
    "subject": "Notificacion",
    "text": "notificacion mail",
    "html": "<h1>Hola!</h1><p>Esta es una notificacion.</p>"
}'
```

### Respuesta esperada

```json
{
  "status": 200,
  "message": "Mensaje enviado a mail1@example.com; mail2@example.com con éxito"
}
```

## Contribución
Si deseas contribuir a este proyecto, puedes hacer un fork del repositorio y enviar un pull request con tus mejoras.

## Licencia
Este proyecto está bajo la licencia **MIT**.
