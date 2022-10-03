import React from "react";
import { BrowserRouter, Route, Link } from "react-router-dom";
import Header from "./Header";
import  StreamEdit from "./pages/SteramEdit"
import  StreamCreate from "./pages/StreamCreate"
import  StreamDelete from "./pages/StreamDelete"
import  StreamList from "./pages/StreamList"
import  StreamShow from "./pages/StreamShow"

// BrowserRouter - work with URL after .com, .edu...
// HashRouter - add # and work with URL after #
// MemoryRouter - does not change current URL but switch between components



function App() {
  return (
    <div className=" ui container">
      
      <BrowserRouter>
        <div>
        <Header/>
          <Route path="/" exact component={StreamList}/>
          <Route path="/streams/new"  component={StreamCreate}/>
          <Route path="/streams/edit"  component={StreamEdit}/>
          <Route path="/streams/delete"  component={StreamDelete}/>
          <Route path="/streams/show"  component={StreamShow}/>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;


// const PageOne = () => {
//   return (
//   <div>PageOne
//     {/* !!!BAD PRACTICE!!! - dump all data, state */}
//     {/* <a href = "/pagetwo">Navigate to next page</a> */}

//     <Link to={"/pagetwo"}>Navigate to next page</Link>
//   </div>);
// };

// const PageTwo = () => {
//   return( 
//     <div>
//       PageTwo
//       <Link to={"/"}>Navigate to first page</Link>
//     </div>);

// };