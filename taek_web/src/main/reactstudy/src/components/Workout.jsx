import React, { useState } from "react";

function Workout(props) {
  console.log(props.workout.name + props.workout.count);
  const handleincrement = (workout) => {
    
    props.onIncrement(props.workout);
    console.log(e);
  };
  // 바닐라스크립트에서 함수는 객체이다.
  const handleDecrement = (e) => {
    // setCount(count <= 0 ? 0 : count -1);
    // setName("랩플다운");
  };
  const handleDelete = () => {};
  return (
    <>
      <li className="workout">
        <span className="workout-name">{props.workout.name}</span>
        <span className="workout-count">{props.workout.count}</span>
        <button
          className="wo-button workout-increase"
          onClick={handleincrement}
        >
          <i className="fas fa-plus-square"></i>
        </button>
        <button
          className="wo-button workout-decrease"
          // onClick={() => setCount(count - 1)} 이걸 아래코드로
          onClick={handleDecrement}
        >
        
          <i className="fas fa-minus-square"></i>
        </button>
        <button className="wo-button workout-delete" onclick => {handleDelete} >
          <i className="fas fa-trash"></i>
        </button>
      </li>
    </>
  );
}

export default Workout;
