import { Link } from 'react-router-dom';
import styles from './MovieCard.module.css';

export function MovieCard({ movie }) {
    return (

        <li key={movie.id} className={styles.movieCard}>
            <Link to={`/detail/${movie.id}`}>
            <img className={styles.movieImg}
                src={'https://image.tmdb.org/t/p/w300' + movie.poster_path}
                alt={movie.title}>
            </img>
            </Link>
            <div>
                {movie.title}
            </div>
        </li>
    )

}