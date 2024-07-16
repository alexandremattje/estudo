export interface ProductOrderDTO {
	id?: number,
	userName: string,
	productType: string,
	timeHour: number
}

export interface OrderListPageResponse {
	content: ProductOrderDTO[]
}