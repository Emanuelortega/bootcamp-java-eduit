import styles from './App.module.css';
import { MovieGrid } from './Components/Movie.Grid';
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import { MovieDetail } from './Components/MovieDetail';
import { SearcMovie } from './Components/SearcMovie';


function App() {
  console.log(styles);

  return (
    <BrowserRouter>
      <header>
        <Link to={'/'}>
          <div>
            <h1 className={styles.title}>Peliculas</h1>
            <SearcMovie/>
          </div>
        </Link>
      </header>

      <main>
        <Routes>
          <Route path='/' element={<MovieGrid/>}/>
          <Route path='/detail/:movieId' element={<MovieDetail/>}/>
        </Routes>
      </main>

    </BrowserRouter>







  );
}

export default App;
