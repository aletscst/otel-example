import nodemailer from 'nodemailer';

export const mailer = nodemailer.createTransport({
    name: process.env.SMTP_NAME,
    host: process.env.SMTP_HOST,
    port: Number(process.env.SMTP_PORT),
    secure: true, // Usa true para 465, false para 587
    auth: {
        user: process.env.SMTP_USER,
        pass: process.env.SMTP_PASS,
    }
});