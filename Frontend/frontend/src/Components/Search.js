import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useEffect, useState } from 'react';

export default function Search() {
        
    const [movies, setMovies] = useState([]);


    const handleClick = (e) => {
        e.preventDefault();
        console.log('¡Hiciste clic!');
        
        fetch('http://localhost:8080/anime/getAll')
        .then(data => {
            if (Array.isArray(data.data)) {
                setMovies(data.data);
            } else {
                console.error('La respuesta de la API:', data);
            }
        })
        .catch(error => {
            console.error('Error al obtener datos:', error);
        });
};

    useEffect(() => {
        fetch('http://localhost:8080/anime/getAll')
            .then(response => response.json())
            .then(data => {
                setMovies(data.data);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
    }, [])
  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '45ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Anime Search" variant="outlined" />
      <Button variant="contained" onClick={handleClick}>Search</Button>
      <ul>
                {movies.map(movie => (
                    <li key={movie.id}>{movie.title}</li>
                ))}
            </ul>
    </Box>




  );
}





