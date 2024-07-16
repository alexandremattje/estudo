import { ProductOrderDTO } from "../../model/dto/ProductOrderDTO"

export interface ListItemProps {
    item: ProductOrderDTO
}

function ListItem(props:ListItemProps) {
    return <>
        <div key={props.item.id} className="flex flex-col">
            <div>{props.item.userName}</div>
            <div>{props.item.productType}</div>
            <div>{props.item.timeHour}</div>
        </div>
    </>
}

export default ListItem