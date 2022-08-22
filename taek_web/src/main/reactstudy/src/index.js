import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import WorkoutApp from "./workoutApp"; // 내가 새로만든 앱이 실행된다.
import App from "./app";
import "@fortawesome/fontawesome-free/js/all.js";


// 페이지가 랜더링이 되는 위치 
const root = ReactDOM.createRoot(document.getElementById("root5")); // 해당하는 앨리먼트에 접근해서
// root에 출력해주세요. 태그선언
root.render(
  <React.StrictMode>
    <WorkoutApp />
    <App />
  </React.StrictMode>
);

// Ctrl + / = 주석
