import { BasicResponse } from "../interfaces/general.interface";
import { TransactionStatus } from "../utils/enums";

export async function testService(data: string): Promise<BasicResponse> {
    return { status: TransactionStatus.SUCESS, message: 'Mensaje enviado con éxito' };
}