import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import BootStrapApp from "./bootStrapApp";
import WorkoutApp from "./workoutApp";
import App from "./app";
import "@fortawesome/fontawesome-free/js/all.js";
import Bootstrap from "./bootStrapApp";

const root = ReactDOM.createRoot(document.getElementById("root5"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Bootstrap>
      </Bootstrap>
    <WorkoutApp />
    {/* <WorkoutApp /> */}
    {/* <App /> */}
    </BrowserRouter>
  </React.StrictMode>
);
