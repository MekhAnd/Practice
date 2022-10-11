import React from "react";
import { Router, Route, Link } from "react-router-dom";
import Header from "./Header";
import StreamEdit from "./pages/StreamEdit"
import StreamCreate from "./pages/StreamCreate";
import StreamDelete from "./pages/StreamDelete";
import StreamList from "./pages/StreamList";
import StreamShow from "./pages/StreamShow";
import history from "../history";

// BrowserRouter - work with URL after .com, .edu...
// HashRouter - add # and work with URL after #
// MemoryRouter - does not change current URL but switch between components

function App() {
  return (
    <div className=" ui container">
      <Router history={history}>
        <div>
          <Header />
          <Route path="/" exact component={StreamList} />
          <Route path="/streams/new" component={StreamCreate} />
          <Route path="/streams/edit/:id" component={StreamEdit} />
          <Route path="/streams/delete" component={StreamDelete} />
          <Route path="/streams/show" component={StreamShow} />
        </div>
      </Router>
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
