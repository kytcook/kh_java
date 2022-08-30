class PageBar {
  totalRecord;
  //페이지당 레코드 수
  numPerPage; // 10개씩이다
  //블럭당 디폴트 페이지 수 - 여기서는 일단 2개로 정함.
  pagePerBlock = 10;
  //총페이지 수
  totalPage;
  //총블럭 수
  totalBlock;
  //현재 내가 바라보는 페이지 수
  nowPage;
  //현재 내가 바라보는 블럭 수
  nowBlock;
  //적용할 페이지 이름
  pagePath;
  pagination;
  // JAVA와는 다르게 오버로딩을 지원하지 않는다는 것을 기억하자.
  constructor(numPerPage, totalRecord, nowPage, pagePath) {
    this.numPerPage = numPerPage;
    this.totalRecord = totalRecord;
    //alert(totalRecord);
    this.nowPage = nowPage;
    this.pagePath = pagePath;
    this.totalPage = Math.ceil(this.totalRecord / this.numPerPage); // 47.0/10=> 4.7 4.1->5page 4.2->5page
    this.totalBlock = Math.ceil(this.totalPage / this.pagePerBlock); //5.0/2=> 2.5-> 3장
    //현재 내가바라보는 페이지 : (int)((double)4-1/2)
    this.nowBlock = Math.floor(this.nowPage / this.pagePerBlock);
  }
  //setter메소드 선언
  setPageBar() {
    console.log("nowBlock:" + this.nowBlock);
    let pageLink = "";
    //전체 레코드 수가 0보다 클때 처리하기
    if (this.totalRecord > 0) {
      //nowBlock이 0보다 클때 처리
      //이전 페이지로 이동 해야 하므로 페이지 번호에 a태그를 붙여야 하고
      //pagePath뒤에 이동할 페이지 번호를 붙여서 호출 해야함.
      if (this.nowBlock > 0) {
        //(1-1)*2+(2-1)=1
        pageLink +=
          "<a href='" +
          this.pagePath +
          "?nowPage=" +
          ((this.nowBlock - 1) * this.pagePerBlock + (this.pagePerBlock - 1)) +
          "'>";
        pageLink += "<img border=0 src='/images/bu_a.gif'>";
        pageLink += "</a>&nbsp;&nbsp;";
      }
      for (let i = 0; i < this.pagePerBlock; i++) {
        //현재 내가 보고 있는 페이지 블록 일때와
        if (this.nowBlock * this.pagePerBlock + i == this.nowPage) {
          pageLink +=
            "<b>" + (this.nowBlock * this.pagePerBlock + i + 1) + "</b>&nbsp;";
        }
        //그렇지 않을 때를 나누어 처리해야 함.
        else {
          pageLink +=
            "<a href='" +
            this.pagePath +
            "?nowPage=" +
            (this.nowBlock * this.pagePerBlock + i) +
            "'>" +
            (this.nowBlock * this.pagePerBlock + i + 1) +
            "</a>&nbsp;";
        }
        //모든 경우에 pagePerBlock만큼 반복되지 않으므로 break처리해야 함.
        //주의할 것.
        if (this.nowBlock * this.pagePerBlock + i + 1 == this.totalPage) break;
      }
      //현재 블록에서 다음 블록이 존재할 경우 이미지 추가하고 페이지 이동할 수 있도록
      //a태그 활용하여 링크 처리하기
      if (this.totalBlock > this.nowBlock + 1) {
        pageLink +=
          "&nbsp;&nbsp;<a href='" +
          this.pagePath +
          "?nowPage=" +
          (this.nowBlock + 1) * this.pagePerBlock +
          "'>";
        pageLink += "<img border=0 src='/images/bu_b.gif'>";
        pageLink += "</a>";
      }
    }
    this.pagination = pageLink;
  }
  //getter메소드 선언
  getPageBar() {
    this.setPageBar();
    return this.pagination;
  }
} // end of PageBar

//Database에서 데이터 가져오기
const db = firebase.firestore();
//====== 페이징 처리에 필요한 변수 선언 ======//
let num = 0;
let total = 0;
let numPerPage = 5; // 한 페이지에 두 개씩 보이게 하기
let nowPage = 0; // 현재 페이지
let params = new URLSearchParams(document.location.search);
nowPage = params.get("nowPage");
//====== 페이징 처리에 필요한 변수 선언 ======//

db.collection("enquire")
  .orderBy("registDate", "asc") //오름차순 정렬
  .get()
  .then((snapshot) => {
    // 콜백영역 - callback 함수, fetch 함수, await, async(동기/비동기)
    console.log(snapshot); // [Object, object] --> JSON.parse() or JSON.stringify()
    // console.log(JSON.parse(snapshot));
    // console.log(JSON.stringify(snapshot));
    total = snapshot.docs.length;
    console.log("전체 레코드 수: " + total);
    // for(let i = 0; i<total; i++){ // 전체 목록을 뽑아내는 for문
    for (
      let i = nowPage * numPerPage;
      i < nowPage * numPerPage + numPerPage;
      i++
    ) {
      // 무조건 페이지 레코드 수만큼 반복되는 구조이므로 해당 페이지에 한 개 레코드만 있는 경우 break 처리!
      if (total === i) break;
      num = i;
      const template = `
                    <tr class = "table">
                      <th scope="row" class="table-primary">${++num}</th>
                      <td>${snapshot.docs[i].data().name}</td>
                      <td>${snapshot.docs[i].data().gender}</td>
                      <td>${snapshot.docs[i].data().phone}</td>
                      <td>${snapshot.docs[i].data().program}</td>
                      <td>${snapshot.docs[i].data().registDate}</td>
                      <td class="table-danger">${
                        snapshot.docs[i].data().reservDate
                      }</td>
                      <td>${snapshot.docs[i].data().p_name}</td>
                      <td id="${snapshot.docs[i].data().p_name}">
                      <button class="del">상담완료</button></td>
                    </tr>
    `;
      $(".enquire-article").append(template);
    } ////// end of for

    /*=============== 삭제 Start ==============*/
    const deletebtn = document.querySelectorAll(".del"); // 클래스명이 del인 버튼(207)을 상수에 저장
    $(document).ready(function () {
      // $(deletebtn).click(function (e) {  }); // 사용시 : forEach삭제
      deletebtn.forEach((deletebtn) => {
        // 버튼 클릭, 삭제
        deletebtn.addEventListener("click", (e) => {
          console.log(e);
          e.stopPropagation(); // 이벤트가 발생한 상태에서 다른 이벤트나 움직임을 강제로 멈추는 기능
          let id = e.target.parentElement.getAttribute("id"); // 이벤트발생시 id가 가진 속성의 부모요소를 타게팅하여 변수에 저장
          db.collection("enquire") // enquire문서에서, 위에서 담은 변수 id 삭제
            .doc(id)
            .delete()
            .then(() => {
              console.log("Document successfully deleted!");
              // location.reload(); // 삭제성공 -> 새로고침
              // window.location.href = "./enquire_1-4f.html";
            })
            .catch((error) => {
              console.error("Error removing document: ", error);
            });
        });
      });
    });
    /*================ 삭제 End ===============*/

    /* 페이지 네비게이션 처리 위치 */
    const pagePath = "enquire-paging_ji.html";
    const pb = new PageBar(numPerPage, total, nowPage, pagePath);
    // console.log(pb.getPageBar()); // class PageBar에서 생성되는 링크 출력해보자
    $(".pagenation").append(pb.getPageBar());
  }); ////// end of callback