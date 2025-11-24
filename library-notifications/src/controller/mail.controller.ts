import { Request, Response } from "express";
import { MailMessage } from "../interfaces/mail.interface";
import { sendMail } from "../services/mail.service";

export async function sendMailMessage(req: Request, resp: Response): Promise<Response> {
    try {

        const body: MailMessage = req.body;
        const responseService = await sendMail(body);
        
        return resp.status(responseService.status).json(responseService);
        
    } catch (err) {
        return resp.status(500).json({ error: err });
    }
}