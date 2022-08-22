import React from "react";
import Workout from "./Workout";

// props 뭔가를 받아온대
function Workout(props) {
  console.log(props);// 객체를받는 경우
  console.log(props.workout.name);// 배열
  const handleIncrement = (workout) => {
    props.onIncrement(workout);
    console.log(workout);
  }
  // 바닐라스크립트에서 함수는 객체이다.
  return (
    <div className="workouts">
      <ul>
        {props.workouts.map((workout) => (
          
        ))}
{
  props.workouts.map(workout => (
    <Workout key={workout.id} workout={workout}/>
  ))
}        

      </ul>
    </div>
  );
}

export default Workouts;
