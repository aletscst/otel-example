import { TransactionStatus } from "../utils/enums";

export interface BasicResponse {
    id?: number;
    status: TransactionStatus;
    message: string;
    errors?: string[];
}