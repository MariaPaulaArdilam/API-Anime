import * as React from 'react';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';
import { useEffect, useState } from 'react';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function BasicStack() {

    const [average, setAverage] = useState([]);
    useEffect(() => {
        fetch('http://localhost:8080/anime/getAverageScore')
            .then(response => response.json())
            .then(data => {
                console.log(data.averageScore);
                setAverage(data);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
    }, [])

  return (
    <Box sx={{ width: '100%' }}>
      <Stack spacing={2}>
        <Item>Average score of all the anime’s seasons: {average.averageScore}</Item>
      </Stack>
      
    </Box>
  );
}