import styles from './MovieCard.module.css';

export function MovieCard({ movie }) {
    return (
        <li key={movie.id} className={styles.movieCard}>
            <img className={styles.movieImg}
                src={'https://image.tmdb.org/t/p/w300' + movie.poster_path}
                alt={movie.title}>
            </img>
            <div>
                {movie.title}
            </div>
        </li>
    )

}