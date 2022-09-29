import React from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import { authRouts, publicRouts } from "../routs";
import { MAIN_ROUTE } from "../utils/consts";

const AppRouter = () => {
    let user = {
        isAuth:true
    }
  return (
    <Switch>
      { user.isAuth && authRouts.map(({ path, Component }) => {
       return( <Route 
            key={path} 
            path={path} 
            component={Component}
            exact />)
      })}
      { publicRouts.map(({ path, Component }) => {
       return (<Route 
            key={path} 
            path={path} 
            component={Component}
            exact />)
      })}
      <Redirect to={MAIN_ROUTE}/>
    </Switch>
  );
};

export default AppRouter;
