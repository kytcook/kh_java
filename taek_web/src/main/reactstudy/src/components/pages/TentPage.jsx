import React from "react";
import { useParams } from "react-router-dom";
import TentDetail from "./TentDetail";
// 자바스크립트는 싱글스레드(timeline) 이다. - forEach 문 --> for문 처리
// 콜백에 대한 이슈
// 문제해결능력 !!! 키움 - 프로젝트
function TentPage(props) {
  const tents = props.tents;
  // console.log(tents); //확인용
  const { id, name } = useParams();
  // console.log(id + ", " + name); // 확인용
  return (
    <div className="container">
      <div className="row">
        {
          tents.map((tent, i)=>(
            <TentDetail key={i} tent={tent}/>
          ))}
      </div>
    </div>
  );
}

export default TentPage;
/* fluid 전체 화면을 다 쓸것인지 */