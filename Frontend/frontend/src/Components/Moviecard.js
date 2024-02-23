import * as React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';

import Typography from '@mui/material/Typography';



export default function Moviecard() {
  const [expanded, setExpanded] = React.useState(false);


  return (
    <Card sx={{ maxWidth: 250 }}>
      <CardHeader
        title="Shrimp and Chorizo Paella"
      />
      <CardMedia
        component="img"
        height="194"
        image="/static/images/cards/paella.jpg"
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          This impressive .
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
        </CardContent>
      </Collapse>
    </Card>
  );
}
