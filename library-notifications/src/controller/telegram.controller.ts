import { Request, Response } from "express";
import { TelegramGroupMessage } from "../interfaces/telegram.interface";
import { sendMessageToGroup } from "../services/telegram.service";

export async function sendTelegramMessageToGroup(req: Request, resp: Response): Promise<Response> {
    try {

        const body: TelegramGroupMessage = req.body;
        const responseService = await sendMessageToGroup(body);
        
        return resp.status(responseService.status).json(responseService);
        
    } catch (err) {
        return resp.status(500).json({ error: err });
    }
}