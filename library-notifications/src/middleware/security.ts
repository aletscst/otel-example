import cors from 'cors';
import { NextFunction, Request, Response } from 'express';
import { APP_KEY_HEADER } from '../utils/enums';

export function corsOptions(): cors.CorsOptions {
    const allowedOrigins = process.env.CORS_ALLOW_ORIGINS?.split(';') || ['*'];
    console.log(allowedOrigins);

    const corsOptions: cors.CorsOptions = {
        allowedHeaders: [APP_KEY_HEADER, 'Content-Type'],
        methods: 'GET, POST',
        origin: allowedOrigins,
    }

    return corsOptions;
}

export function veryfyApiKey(req: Request, res: Response, next: NextFunction) {
    const apiKey = req.header(APP_KEY_HEADER);
    if (apiKey !== process.env.API_KEY) {
        return res.status(401).json({ message: 'Unauthorized' });
    }

    next();
}