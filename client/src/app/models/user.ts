import {RunsType} from "./runs-type.enum";

export interface User {
    userId?: number,
    firstName: string,
    lastName: string,
    identityCardNumber: string,
    run: RunsType,
    pay: boolean,
    active?: boolean,
    startDate?: Date,
    additionalText?: string,
    endDate?: Date
}
