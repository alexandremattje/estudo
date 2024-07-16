import { useForm } from "react-hook-form"
import { z } from 'zod'
import { zodResolver} from "@hookform/resolvers/zod"
import { ProductOrderDTOSchema, ProductOrderDTODataType } from "../../schema/ProductOrderSchema";
import { useOrderMutate } from "../../hooks/useOrderMutate";
import { ProductOrderDTO } from "../../model/dto/ProductOrderDTO";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Venda() {
    const { mutate, isSuccess } = useOrderMutate()
    const navigate = useNavigate();

    const { 
        register, 
        handleSubmit, 
        formState: {errors}
    } = useForm<ProductOrderDTODataType>({
        resolver: zodResolver(ProductOrderDTOSchema)
    })

    console.log(errors)

    function create(data: ProductOrderDTO) {
        console.log(data);
        
        mutate(data);

    }

    useEffect(() => {
        if (isSuccess) {
            navigate("/")
        }
        console.log(isSuccess)
    }, [isSuccess]);

    return <>
        <form
            onSubmit={handleSubmit(create)}
        >
            <div>
                <label>User:</label>
                <input 
                    type="text" 
                    placeholder="user name"
                    {...register('userName')}
                />
                {errors.userName && <span>{errors.userName.message}</span>}
            </div>
            <div>
                <label>Product Type:</label>
                <input 
                    type="text" 
                    placeholder="Product"
                    {...register('productType')}
                />
                {errors.productType && <span>{errors.productType.message}</span>}
            </div>
            <div>
                <label>Time hour:</label>
                <input 
                    type="number" 
                    placeholder="Time hour"
                    {...register('timeHour')}
                />
                {errors.timeHour && <span>{errors.timeHour.message}</span>}
            </div>                        
            <button
                type="submit"
                >Salvar</button>
        </form>
    </>
}

export default Venda