import { Request, Response } from "express";

import { testService } from "../services/test.service";
import { logger } from "../config/app.config";

export async function testController(req: Request, resp: Response): Promise<Response> {
    try {
        logger.info('testController');
        const testResp = await testService(req.body);
        return resp.status(testResp.status).json(testResp);
    } catch (err) {
        return resp.status(500).json({ error: err });
    }
}