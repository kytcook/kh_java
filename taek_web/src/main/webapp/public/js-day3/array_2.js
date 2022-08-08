// showlow copy : 배열의 얕은 복사
// 자바스크립트에서는 얕은 복사가 이뤄진다.
// Array.from, cocat, slice, spread(...), Object.assign 로 하면 모두 다 얕은 복사임.
const sonata = {carColror : 'red'   , speed : (60)};
const casper = {carColror : 'white' , speed : (60)};
const pride  = {carColror : 'black' , speed : (60)};

const hyundai = [sonato, casper];
const kia     = Array.from(hyundai);
console.log(hyuundai);
sonatao.speed = 100;
console.log(hyuundai);
clg(kia);
