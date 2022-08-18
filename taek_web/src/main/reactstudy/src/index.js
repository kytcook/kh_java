import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import WorkoutApp from "./workoutApp"; // 내가 새로만든 앱이 실행된다.
import "@fortawesome/fontawesome-free/js/all.js";

const root = ReactDOM.createRoot(document.getElementById("root5")); // 해당하는 앨리먼트에 접근해서
root.render(
  <React.StrictMode>
    <WorkoutApp />
  </React.StrictMode>
);
