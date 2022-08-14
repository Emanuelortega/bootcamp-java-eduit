import { MovieGrid } from "./MovieGrid";
import { SearchMovie } from './SearchMovie';

export function Landing() {
    return (
        <>
            <SearchMovie/>
            <MovieGrid/>
        </>
    );
}