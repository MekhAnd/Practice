import React from 'react';
import ReactDOM from 'react-dom/client';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from "redux"; 
import thunk from "redux-thunk"

import App from "./components/App";
import redusers from "./redusers";

const root = ReactDOM.createRoot(document.getElementById('root'));
const store = createStore(redusers, applyMiddleware(thunk))
root.render(
  <Provider store={store}>
    <App />
  </ Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

