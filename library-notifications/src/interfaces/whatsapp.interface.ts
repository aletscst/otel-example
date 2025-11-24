export interface WhatsappMessage {
    phone: string;
    message: string;
}

export interface VerificationMessage extends WhatsappMessage {
    name: string;
    lastName: string;
    email: string;
}

export interface VerifyCode {
    phone: string;
    code: string;
}