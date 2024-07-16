import { AxiosPromise } from "axios";
import { api } from "../tools/api";
import { OrderListPageResponse } from "../model/dto/ProductOrderDTO";

export const get = (): AxiosPromise<OrderListPageResponse> => {
    return api.get<OrderListPageResponse>(`/orders/list?productType=SURFBOARD&page=0&offSet=20`);
}