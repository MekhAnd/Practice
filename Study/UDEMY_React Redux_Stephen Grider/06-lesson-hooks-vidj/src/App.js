import React from "react";
import Accordion from "./components/Accordion";
import Search from "./components/Saerch";
import DropDown from "./components/DropDown";
import { useState } from "react";
import Translate from "./components/Translate";
import Route from "./components/Rout";
import Header from "./components/Header";

const items = [
  {
    title: "What is React?",
    content: "React is a frontend javascript framework",
  },
  {
    title: "Why use React?",
    content: "React is a favorite JS library among engineers",
  },
  {
    title: "How do you use Rect?",
    content: "You use React by creating components",
  },
];

const options = [
  {
    label: "Red",
    value: "red",
  },
  {
    label: "The color green",
    value: "green",
  },
  {
    label: "This is BLUE",
    value: "blue",
  },
];

function App() {
  const [selected, setSelected] = useState(options[0]);

  return (
    <div>
      <Header />
        <Route path="/">
          <Accordion items={items} />
        </Route>
        <Route path="/list">
          <Search />
        </Route>
        <Route path="/dropdown">
          <DropDown
            label="Select a Color"
            selected={selected}
            onSelectedChange={setSelected}
            options={options}
          />
        </Route>
        <Route path="/translate">
          <Translate />
        </Route>
      
    </div>
  );
}

export default App;

/*******Llike one of the variants solve the path question*******/

// const showAccordion = () => {
//   if (window.location.pathname === "/") {
//     return <Accordion items={items} />;
//   }
// };

// const showSeatrch = () => {
//   if (window.location.pathname === "/list") {
//     return <Search />;
//   }
// };

// const showDropDown = () => {
//   if (window.location.pathname === "/drop") {
//     return <DropDown
//             // label = {SelectColor}
//             // selected = {selected}
//             // onSelectedChange = {setSelected}
//             // options = {options}
//             />;
//   }
// };

// const showTraslate = () => {
//   if (window.location.pathname === "/translate") {
//     return <Translate/>;
//   }
// };
