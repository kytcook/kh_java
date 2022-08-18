import React, { useState } from "react";
import Workout from "./components/Workout";
import "./app.css";

function WorkoutApp() {
  const [items, setItems] = useState([
    { id: 1, name: "벤치프레스", count: 0 },
    { id: 2, name: "랫플다운", count: 0 },
    { id: 3, name: "스쿼트", count: 0 },
  ]);
  return <Workout />; // 싱글페이지 어플리케이션이다. 여러조각의 화면을 한 화면에서 처리가 가능하다
}

export default WorkoutApp;

// rsf : function으로 자동완성을 만들어준다
