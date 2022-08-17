import React from "react";

function Workout(props) {
  // 상태를 관리해 본다.
  state = {
    count: 0,
  };
  return (
    <>
      <li className="workout">
        <span className="workout-name">{"데드리프트"}</span>
        <button>
          <i className="fas fa-plus-square"></i>
        </button>
        <button>
          <i className="fas fa-minus-square"></i>
        </button>
        <button>
          <i className="fas fa-trash"></i>
        </button>
      </li>
    </>
  );
}

export default Workout;

// 내용에 관한 파일이다.