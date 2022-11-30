// 메세지 슬라이드
const div = document.querySelector("div.slides");
const lastDiv = document.createElement("div");
const firstDiv = document.createElement("div");
var count = 0;

firstDiv.innerHTML = `나의 성장을 돕는 뫼비우스`;
div.insertBefore(firstDiv, document.querySelector("div.slides div"));
lastDiv.innerHTML = `성장에 목마를 땐, 뫼비우스`;
div.appendChild(lastDiv);

div.style.transform = "translate(-320px)";

let intervalTime = 3000;
let inter = setInterval(autoSlide, intervalTime);

function autoSlide() {
    div.style.transition = "transform 0.5s";
    count++;
    if (count == 5) {
        // 마지막 배너(5번)
        div.style.transform = "translate(-" + 320 * (count + 1) + "px)";
        count = 0;
        setTimeout(function () {
            div.style.transition = "transform 0.0s";
            div.style.transform = "translate(-320px)";
        }, 500);
    } else {
        div.style.transition = "transform 1.5s";
        div.style.transform = "translate(-" + 320 * (count + 1) + "px)";
    }
}
