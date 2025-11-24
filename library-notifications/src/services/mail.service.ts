import { mailer } from "../config/mail.config";
import { BasicResponse } from "../interfaces/general.interface";
import { MailMessage } from "../interfaces/mail.interface";
import { TransactionStatus } from "../utils/enums";

export async function sendMail(data: MailMessage): Promise<BasicResponse> {
    try {
        const info = await mailer.sendMail({
            sender: process.env.SMTP_USER,
            from: process.env.SMTP_USER,
            cc: data.cc,
            bcc: data.bcc,
            to: data.to,
            subject: data.subject,
            text: data.text,
            html: data.html
        });

        return { id: +info.messageId, status: TransactionStatus.SUCESS, message: `Mensaje enviado a ${data.to} con éxito` };
    } catch (error) {
        console.error('Error al enviar el mensaje:', error);
        return { status: TransactionStatus.INTERNAL_SERVER_ERROR, message: 'Error al enviar el mensaje' };
    }

}