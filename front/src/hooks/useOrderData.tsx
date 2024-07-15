import { useQuery } from "@tanstack/react-query"
import { get } from "../service/VendaService"

export function useOrderData () {
    const query = useQuery({
        queryFn: get,
        queryKey: ['useOrderData']
    })

    return {
        ...query,
        data: query.data?.data
    }
}