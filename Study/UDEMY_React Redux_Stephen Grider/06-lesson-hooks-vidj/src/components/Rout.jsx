import { useState } from "react";
import { useEffect } from "react";

const Route = ({ path, children }) => {
  const [currentPath, setCUrrentPath] = useState(window.location.pathname);
  useEffect(() => {
    const onLocationChange = () => {
      setCUrrentPath(window.location.pathname);
    };
    window.addEventListener("popstate", onLocationChange);

    return () => {
      window.removeEventListener("popstate", onLocationChange);
    };
  }, []);

  return currentPath === path ? children : null;
};

export default Route;
