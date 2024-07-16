import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Dashboard from '../dashboard/Dashboard';
import Login from '../login/Login';
import Venda from '../venda/Venda';

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={<Dashboard />}
          />
          <Route path="/login" element={<Login />} />
          <Route path="/venda" element={<Venda />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
