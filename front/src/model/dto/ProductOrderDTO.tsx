export interface ProductOrderDTO {
	userName: string,
	productType: string,
	timeHour: number
}

export interface OrderListPageResponse {
	content: ProductOrderDTO[]
}