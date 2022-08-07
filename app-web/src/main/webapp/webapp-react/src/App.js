import styles from './App.module.css';
import { MovieGrid } from './Components/Movie.Grid';


function App() {
  console.log(styles);

  return (<>

    <header>
      <h1 className={styles.primerParrafo}>peliculas</h1>
    </header>

    <main>
      <MovieGrid ></MovieGrid>
    </main>



  </>



  );
}

export default App;
