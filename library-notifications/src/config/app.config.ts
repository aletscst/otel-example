import 'dotenv/config';
import express, { Application } from "express";
import cors from 'cors';

import { corsOptions, veryfyApiKey } from '../middleware/security';

import telegramRouter from '../routes/telegram.route';
import mailRouter from '../routes/mail.route';
import testRouter from '../routes/test.route';

import { clients_connection, xipatlani_connection } from './db.config';

import winston from 'winston';

export const logger = winston.createLogger({
    level: 'info',
    format: winston.format.json(),
    transports: [
        new winston.transports.Console(),
        new winston.transports.File({ filename: 'error.log', level: 'error' }),
        new winston.transports.File({ filename: 'combined.log' }),
    ],
});

export class AppConfig {
    constructor(private app: Application) {
        this.loadPort();
        this.middlewares();
        this.routes();        
        //this.dbConection();
    }

    private loadPort() {
        const port = process.env.PORT || 3000;
        this.app.set('port', port);

        logger.info(`Port: ${port}`);
    }

    async dbConection() {
        try {
            await clients_connection.authenticate();
            await xipatlani_connection.authenticate();
            console.log('DB Connection has been established successfully.');
        } catch (error) {
            console.log('Unable to connect to the database:', error);
            process.exit(1);
        }
    }

    middlewares() {
        this.app.use(express.json());
        this.app.use(cors(corsOptions()));
    }

    routes() {
        // set routes here
        this.app.use('/telegram', veryfyApiKey, telegramRouter);
        this.app.use('/mail', veryfyApiKey, mailRouter);
        this.app.use('/health', testRouter);
        // example with other middlewares
        // this.app.use(/route, middleware, routes);
        // with jwt
        // this.app.use('/route', verifyToken, routes);
    }
}