import './Dashboard.css';
import { useOrderData } from "../../hooks/useOrderData";
import { useOrderMutate } from "../../hooks/useOrderMutate";
import { Route, useNavigate } from 'react-router-dom';
import ListItem from './ListItem';

function Dashboard() {

    const { data } = useOrderData()

    const navigate = useNavigate()

    const handleCriarButtonClick = () => {
      navigate("/venda")
    }
  
    return (
      <div>
      <header>
        <button onClick={handleCriarButtonClick}>Criar venda</button>
        </header>
        <body>
        Lista de vendas
          { data?.content.map((venda, i) => {
            return <ListItem item={venda} />
          })}
        </body>
      </div>
    );

  }
  
  export default Dashboard;