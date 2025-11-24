import { Router } from "express";
import { sendTelegramMessageToGroup } from "../controller/telegram.controller";

const router: Router = Router();

router.post('/send-message-group', sendTelegramMessageToGroup);

export default router;