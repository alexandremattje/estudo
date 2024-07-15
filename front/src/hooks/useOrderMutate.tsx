import { useMutation, useQueryClient } from "@tanstack/react-query"
import axios from "axios";
import { ProductOrderDTO } from "../model/dto/ProductOrderDTO";

const post = async (data: ProductOrderDTO) => {
    return await axios.post('http://localhost:8080/orders/create', data);
}

export function useOrderMutate() {
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: post,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: ['useOrderData']})
        }
    });

    return mutate;

}