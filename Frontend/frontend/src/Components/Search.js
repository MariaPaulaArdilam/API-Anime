import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useEffect, useState } from 'react';
import { Carousel, Row, Col, Card } from 'react-bootstrap';
import '../Styles/CarouselStyles.css'
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Search() {
        
    const [movies, setMovies] = useState([]);
    const [titleName, setTitleName]  = useState('');
    const [index, setIndex] = useState(0);

    const handleInputChange = (e) => {
        setTitleName(e.target.value);
    };


    const handleClick = (e) => {
        e.preventDefault();
        console.log('¡Hiciste clic!');

        fetch(`http://localhost:8080/anime/byTitle?name=${titleName}`)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data)) {
                setMovies(data);
                setIndex(0);
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
                setMovies(data);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
    }, [])
    
      const handlePrev = () => {
        setIndex(index - 1);
      };
    
      const handleNext = () => {
        setIndex(index + 1);
      };

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 5 },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" value={titleName} onChange={handleInputChange} label="Anime Search" variant="outlined" />
      <Button variant="contained" onClick={handleClick}>Search</Button>
      
      <Row className="justify-content-center mt-4">
                <Col xs={12} md={10}>
                    <Carousel slide={true} interval={null} indicators={false} controls={true} pause={false}>
                        {movies.map((movie, index) => (
                            index % 5 === 0 && (
                                <Carousel.Item key={index}>
                                    <Row>
                                        {movies.slice(index, index + 5).map(movie => (
                                            <Col key={movie.id}>
                                                
                                                <Card>
                                                <div className='card-image-conteiner'>
                                                    <Card.Img variant="top" src={movie.image} alt={movie.title} className='card-image'/>
                                                    </div>  
                                                    <Card.Body>
                                                        <Card.Title>{movie.title}</Card.Title>
                                                        <Card.Text>Score: {movie.score}</Card.Text>
                                                        {movie.score >= 8 && (
                            <Card.Text className="text-success">Great, this is one of the best anime</Card.Text>
                          )}
                          {movie.score >= 5 && movie.score < 8 && (
                            <Card.Text className="text-warning">You may have fun</Card.Text>
                          )}
                          {movie.score < 5 && (
                            <Card.Text className="text-danger">I don't recommend it</Card.Text>
                          )}
                                                    </Card.Body>
                                                </Card>
                                                
                                            </Col>
                                        ))}
                                    </Row>
                                </Carousel.Item>
                            )
                        ))}
                    </Carousel>
                </Col>
            </Row>
    </Box>




  );
}





