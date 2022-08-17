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
  /* 아래에서 화면을 선언합니다. */
  /* 멀티라인으로 태그 앨리먼트들을 두줄 세줄 쓰려면 바깥쪽에 Fragment가 있어여 한다,*/
  /* return 안에 태그를 작성할 수 있다. */
  /* 변수가 없는데 왜 선언?????? */
  return (
    /* <> = React.Fragment -> 리액트에서는 태그를 선언하여 사용함 - 벌타라인을 작성하려면 최외각에 '반드시' 프레그먼트 태그를 붙인다.  */
    /* jsp => java+html
       리액트 ui안에는 html태그와 javascript를 혼용하여 쓸 수 있다.
       리액트는 바로 오류가 뚸서 바로바로 확인이 가능하다.
       리액트 프로젝트도 구조가 있다.
    */
    <>
      <h1>Hello! {name}</h1>; 
      <h1>Hello! {name}</h1>;
      {
        // 자바스크립트 코드를 작성할 수 있다.ㅇ
        name && <h1>Hi!!! {name} </h1>
      }
      {["🥗", "🌮", "🥖"].map((item, index) => (
        console.log(index),
        <h1>{item}</h1>// 키에다가 왜 인덱스를 주었는가??
        
      ))}
    </>
  );
}

export default App;
