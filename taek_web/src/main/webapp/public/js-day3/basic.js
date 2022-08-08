// react에서는 arrow function을 사용합니다.
/* 1 */
function hap(a, b) {
  return a + b;
}
console.log("시험케이스1 : ", hap(1, 2));
/* 2 */
const hap2 = (a, b) => {
  return a + b;
};
console.log("시험케이스2 : ", hap(4, 50));
/* 3 */
const hap3 = (a, b) => a + b;
const total = hap; // 함수도 오브젝트이므로 주번을 갖기 때문에..
console.log(total(2, 3));
console.log(hap2(2, 3));
console.log(hap3(2, 3));
// 1,2,3 모두 결과값은 같지만 arrow function을 사용함으로써 return값과 중괄호가 생략된다. 코드가 간-결

console.log("--------------------마이너스 함수------------------------");

const minus = (a, b) => a - b;
const multiply = (a, b) => a * b;

// 전달된 action은 콜백함수이다. - java actionPerformed(ActionEvent ae)
// 콜백함수 : 언젠가 실행해 줄게. 단, 네가 요청하면
// 전달될 당시에 (action) 함수를 바로 호출해서 반환된 값을 전달하는 것이 아니라. 함수를 가리키고 있는 주소번지가 전달된다.
function account(a, b, action) {
  // action은 minus or multiply 고차함수라고 한다. 고차함수 안에서 필요한 순간에 호출이 나중에 일어난다.
  let result = action(a, b);
  console.log(result);
  return result;
}
// 어떤 함수가 전달되는가에 따라 계산 결과가 달라진다.
console.log(account(2, 1, minus)); // 함수를 가리키는 주번을 넘김
console.log(account(2, 1, multiply));

// 즉시 실행함수 IIFE

/* 
  입력 - 처리 - 출력
  처리와 관련있는 것 - function, operator
  함수의 정의 - 특정한 일을 수행하는 집합
  함수도 오브젝트이다. 함수가 있는 곳을 가리키게 된다.
  콜백함수에서는 함수의 이름은 함수를 참조함. 주소번지를 가지게 있다.
 */
