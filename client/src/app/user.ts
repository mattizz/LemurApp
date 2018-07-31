import {RouteType} from "./route-type.enum";

export interface User {
    userId: number,
    firstName: string,
    identityCardNumber: string,
    additionalText: string,
    run: RouteType,
    pay: boolean,
    isActive: boolean,
    startDate: Date,
    endDate?: Date,
    lastName?: string
}
