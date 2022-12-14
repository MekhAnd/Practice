import { BrowserRouter } from "react-router-dom";

import "./style/App.css";
import AppRouter from "./AppRouter";
import NavBar from "./NavBar";
import MenuBar from "./MenuBar";
import Footer from "./Footer";


function App() {
  
  return (
    <BrowserRouter>
      <NavBar/>
      <MenuBar/>
      <AppRouter />
      <Footer/> 
    </BrowserRouter>
  );
}

export default App;
