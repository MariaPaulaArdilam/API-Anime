import { Card } from '@mui/material';
import './App.css';
import HeaderBar from './Components/HeaderBar';
import Search from './Components/Search';
import AverageScore from './Components/AverageScore';





function App() {
  return (
    <div className="App">
      <HeaderBar/>
      <AverageScore/>
      <Search/>
    </div>
  );
}

export default App;
