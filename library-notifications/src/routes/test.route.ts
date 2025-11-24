import { Router } from "express";
import { testController } from "../controller/test.controller";

const router: Router = Router();

router.post('/test', testController);

export default router;