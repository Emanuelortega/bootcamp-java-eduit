import { MovieCard } from './MovieCard';
//import peliculas from './movies.json';
import styles from './MovieGrid.module.css';
import {useState,useEffect} from 'react';

export function MovieGrid() {

//estado > useState
const[ peliculas, setPeliculas]= useState ([]);

//useEfecct
    useEffect(()=>{

    fetch('https://api.themoviedb.org/3/discover/movie?api_key=4b05dc7686ee63d0138190b53fa4880d&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate')
    .then(response => response.json())
    .then(data => setPeliculas(data.results));
    },[]);

    return (
        <ul className={styles.movieGrid}>
            {peliculas.map((movie) => {
                return <MovieCard key = {movie.id} movie={movie}></MovieCard>

            })
            }
        </ul>

    );

}