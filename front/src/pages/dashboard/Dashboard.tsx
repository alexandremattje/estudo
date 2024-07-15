import './Dashboard.css';
import { useOrderData } from "../../hooks/useOrderData";
import { useOrderMutate } from "../../hooks/useOrderMutate";

function Dashboard() {

    const { data } = useOrderData()
    const { mutate } = useOrderMutate()
  
    const handleCriarButtonClick = () => {
      mutate({userName: 'userName', productType: 'SURFBOARD', timeHour: 1});
    }
  
    return (
      <div>
      <header>
          <button onClick={handleCriarButtonClick}>Criar venda</button>
        </header>
        <body>
        Lista de vendas
          { data?.content.map((venda, i) => {
            return <div className="item" id="{venda.id}">{venda.userName}</div>
          })}
        </body>
      </div>
    );

  }
  
  export default Dashboard;