import './App.css';
import Navbar from './components/Navbar/Navbar';
import Mainphoto from './components/Mainfoto/Mainphoto';
import Article from './components/Article/Article';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Mainphoto/>
      <Article/>
    </div>
  );
}

export default App;
