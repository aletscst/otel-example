import express, { Application } from "express";
import { AppConfig, logger } from "./config/app.config";


export class App {

    private app: Application;

    constructor() {
        this.app = express();
        this.loadConfig();
    }

    private loadConfig() {
        new AppConfig(this.app);
    }

    async listen() {
        const port = this.app.get('port');
        await this.app.listen(port, () => logger.info(`Server on port ${port}`));
    }
}