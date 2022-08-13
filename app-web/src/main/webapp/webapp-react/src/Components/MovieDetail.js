import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import styles from './MovieDetail.module.css';

export function MovieDetail() {

    //cuando la variable de la url
    // /algo/321 es un pathParams
    // cuando es ?clave=valor es un query params(query string)

    //declaro el useState
    const [movie, setMovie] = useState(null);

    const [isLoading, setLoading] = useState(false);
    //esto lo vamos a tomar desde el pathParamns
    const { movieId } = useParams();

    useEffect(() => {
        fetch(`https://api.themoviedb.org/3/movie/${movieId}?api_key=4b05dc7686ee63d0138190b53fa4880d&language=en-US`)
            .then(response => response.json())
            .then(data => { setMovie(data); setLoading(true) });
    }, []);

    //no mostrar si la pelicula esta cargando
    if (!movie) {
        return null;
    }

    const imageURL = 'https://image.tmdb.org/t/p/w500/' + movie.poster_path;
    return (
        <>
            {isLoading && <>
                <div className={styles.detailsConteiner}>
                    <img src={imageURL}
                        alt={movie.title}
                        width={500}
                        height={'auto'}
                        className={styles.movieImage}>
                    </img>
                    <div className={styles.col}>
                        <p>Title: {movie.title}</p>
                        <p>Genders: {movie.genres.map(g => g.name).join(',')}</p>
                        <p> Home Page: 
                            <a className={styles.movieUrl}
                                href={movie.homepage} 
                                target='blank'>{movie.title}
                            </a>
                        </p>
                    </div>
                </div>
            <Link to={'/'}>
                <p className={styles.volverLink}>Volver</p> 
            </Link>
            </>
            }

            
            {!isLoading &&

                <div>
                    <h1>Loading...</h1>
                </div>
            }
        </>
    );
}
