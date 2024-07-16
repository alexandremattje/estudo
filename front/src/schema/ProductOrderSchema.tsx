import { z } from 'zod'

export const ProductOrderDTOSchema = z.object({
    userName: z.string().nonempty("Required"),
    productType: z.string(),
    timeHour: z.coerce.number().min(1).max(100)
})

export type ProductOrderDTODataType = z.infer<typeof ProductOrderDTOSchema>
