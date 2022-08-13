import { useState } from "react";

export function SearcMovie(){

    const [ searchKey, setSearchKey] = useState('');

    const updateSearch = (e) => {
        setSearchKey(e.target.value)
    }

    const searchMovie = () =>{
        //consultyar un api con el parametro = searchKey
         // https://api.themoviedb.org/3/search/movie?query=${searchKey}&api_key=<<api_key>>&language=en-US&page=1&include_adult=false
        alert(searchKey);
    }

    return(
        <>
        <input placeholder="buscar"
        value = {searchKey} onChange={(e) => updateSearch(e)}/>
        <button onClick={searchMovie}>
            Buscar
        </button>
        </>
    );
}