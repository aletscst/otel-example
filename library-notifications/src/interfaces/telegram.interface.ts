export interface TelegramGroupMessage {
    chatID: string;
    messageThreadID: string | null;
    message: string;
}