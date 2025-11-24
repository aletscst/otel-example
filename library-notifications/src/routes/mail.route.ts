import { Router } from "express";
import { sendMailMessage } from "../controller/mail.controller";

const router: Router = Router();

router.post('/send-mail', sendMailMessage);

export default router;