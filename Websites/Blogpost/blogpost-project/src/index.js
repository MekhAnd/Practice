// const Dotenv = require('dotenv-webpack')
import React from 'react';
import ReactDOM from 'react-dom/client';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from "redux"; 
import thunk from "redux-thunk"


import redusers from "./redusers"
import App from './components/App';
import "../src/components/style/App.css"

const root = ReactDOM.createRoot(document.getElementById('root'));
export const store = createStore(redusers, applyMiddleware(thunk))

root.render(
  <Provider  store = { store }>
    <App />
  </Provider >
);

