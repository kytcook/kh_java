import React from "react";
import "./app.css";
/* min이 있는것은 띄어쓰기가 다 빠진것 */
import "bootstrap/dist/css/bootstrap.min.css";

/* 
  함수안에 화면을 같이 작성한다
  { 중괄호 } 안에 변수를 바로 사용한다
*/
function App() {
  const name = "이순신";
  /* 프래그먼트는 <> 생략 가능 */
  return (
    <React.Fragment>
      return <h1>Hello! {name}</h1>; return <h1>Hello! {name}</h1>;
      {
        // 자바스크립트 코드를 작성할 수 있다.
        name && <h1>Hi!!! {name} </h1>
      }
      {["🥗", "🌮", "🥖"].map((item) => (
        <h1>{item}</h1>
      ))}
    </React.Fragment>
  );
}

export default App;
