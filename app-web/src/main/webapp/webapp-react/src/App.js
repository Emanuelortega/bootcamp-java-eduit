import logo from './logo.svg';
import { useState } from 'react';
import DiasDeSemana from'./Components/DiasDeSemana';
import './App.css';
import PrimerComponente from './Components/PrimerComponente';

const dias = [
  'LUNES',
  'MARTES',
  'MIERCOLES',
] ;




function App() {

  //variables
  //hook useState()

  //estado local del componente
  const [edad, setEdad] = useState(0);
  const [valor, setValor] = useState('');
  const [diasDeSemana,setDiasDeSemana] = useState(dias);


  //Arrow function/ funcion flecha
  const incrementar = () => {
    if (edad < 3) {
      setEdad(edad + 1);
    }
  }

  const decrementar = () => {
    if (edad > 0) {
      setEdad(edad - 1);
    }
  }

  const cambiar = () => {
    setEdad(valor);
  }

  const change = (newValor) => {
    console.log(newValor);
    setValor(newValor);
  }



  return (
    <>
      <div className='row'>
        <div className='col-4'>
          <label htmlFor='valor'>Valor</label>
          <input type='number'
            id='valor'
            value={valor}
            onChange={(e) => change(e.target.value)}></input>
          <label>Edad: {edad}</label>

          <DiasDeSemana 
            diasDeSemana={diasDeSemana}
            diaActual={'LUNES'}>
          </DiasDeSemana>
          
          {/*<div className='col'>
            <hi>Dias:</hi>
            <ul>
              {
                diasDeSemana.map((dia,index) =>{
                  return <li key={index}>{dia}</li>
                })
              }
            </ul>
            </div>*/}

        </div>
        <div className='col-8'>
          <button className='btn btn-info'
            onClick={incrementar}>
            Incrementar Edad
          </button>
          <button className='btn btn-success'
            onClick={decrementar}>
            Decrementar Edad
          </button>
          <button className='btn btn-primary'
            onClick={cambiar}>
            Cambiar Edad
          </button>
        </div>
      </div>
    </>
  );
}

export default App;
