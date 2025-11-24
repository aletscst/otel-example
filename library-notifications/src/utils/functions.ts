export function convertStandardPhone(phone: string): string {
    return phone.replace(/[^0-9]/g, '');
}

export function convertPhoneToWhatsapp(phone: string): string {
    phone = phone.replace(/[^0-9]/g, '');
    if(phone.startsWith('52')) {
        phone = '521' + phone.slice(2, phone.length);
    }

    return phone;
}

export function isValidPhone(phone: string): boolean {
    if(phone.length < 12) {
        return false;
    }

    return true;
}

export function getVerificationCode(): string {
    return '' + Math.floor(100000 + Math.random() * 900000);
}