
/*$("a.place").on("click", function(e){
    e.preventDefault();
    location.href = "/place/placeInfo";
});*/

const div = document.querySelector("div.slide_banner");
var count = 0;


let inter = setInterval(autoSlide,2500);

const firstDiv = document.createElement("div");
const lastDiv = document.createElement("div");

firstDiv.innerHTML = `<img src ="https://cdn.inflearn.com/public/main_sliders/7f3b415a-7267-49fc-9c68-9926b8c5f600/%5B22%E1%84%90%E1%85%A2%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%AB%E1%84%83%E1%85%B5%E1%86%BC%5Db2b_top50_main_521.gif">`;
div.insertBefore(firstDiv, document.querySelector("div.slide_banner div"));

lastDiv.innerHTML = `<img src ="https://cdn.inflearn.com/public/main_sliders/68a15e47-7f40-444c-af73-60ab1acb8b3f/%5B%EB%B8%8C%EB%9E%9C%EB%93%9C%5D%EC%B1%84%EC%9A%A9%EC%9D%B4%EB%AF%B8%EC%A7%80%26%EA%B4%91%EA%B3%A0%EB%A6%AC%EB%89%B4%EC%96%BC_main_521.gif">`;
div.append(lastDiv);

div.style.transform = "translate(-83vw)";

function autoSlide(){
    count++;
    if(count == 5){
        div.style.transform = "translate(-" + 83 * (count + 1) +"vw)"
        count = 0;
        setTimeout(function(){
            div.style.transition = "transform 0s";
            div.style.transform = "translate(-83vw)";

        },500);

    }else {
        div.style.transform = "translate(-" + 83 * (count + 1) +"vw)"
        div.style.transition = "transform 0.5s";
    }
}

const btns = document.querySelectorAll(".pagination_bullet");

btns.forEach((btn, i) => {

    btn.addEventListener("click", function(){
        count = i;
        div.style.transform = "translate(-" + 83 * count +"vw)"

    });
});
