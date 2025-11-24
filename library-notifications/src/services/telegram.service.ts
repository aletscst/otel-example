import { BasicResponse } from "../interfaces/general.interface";
import { TelegramGroupMessage } from "../interfaces/telegram.interface";
import { TransactionStatus } from "../utils/enums";

export async function sendMessageToGroup(data: TelegramGroupMessage): Promise<BasicResponse> {
    try {
        if (process.env.TELEGRAM_BOT_KEY) {
            const response = await fetch(`https://api.telegram.org/bot${process.env.TELEGRAM_BOT_KEY}/sendMessage`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    chat_id: data.chatID,
                    message_thread_id: data.messageThreadID,
                    text: data.message,
                    parse_mode: "Markdown"
                }),
            });

            if (response.ok) {
                return { status: TransactionStatus.SUCESS, message: 'Mensaje enviado con éxito' };
            } else {
                console.error('Error al enviar el mensaje:', response);
                return { status: TransactionStatus.INTERNAL_SERVER_ERROR, message: 'Error al enviar el mensaje' };
            }
        } else {
            return { status: TransactionStatus.INTERNAL_SERVER_ERROR, message: 'Token de telegram no encontrado' };
        }
    } catch (error) {
        console.error('Error al enviar el mensaje:', error);
        return { status: TransactionStatus.INTERNAL_SERVER_ERROR, message: 'Error al enviar el mensaje' };
    }
}

function getGroupParams(params:string): Map<string, string> {
    const groupParams = new Map<string, string>();
    const paramsArray = params.split(';');

    paramsArray.forEach(param => {
        const [key, value] = param.split('=');
        if (key && value) {
            groupParams.set(key.trim(), value.trim());
        }
    });

    return groupParams;
    
}
