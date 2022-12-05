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

const input = document.createElement("inp");

input.addEventListener("click",function () {
    if(input === null){
        return alert("정보를 입력해주세요");
    }

});

function checkId(){
    var id = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:'/join/idCheck', //Controller에서 요청 받을 주소
        type:'post', //POST 방식으로 전달
        data:{userEmail:id},
        success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
            if (cnt == 0){
                $("#result").html("사용가능한 이메일 입니다.");
                $("#result").css('color','blue');
                $("#result").css('visibility','visible');
                flag3 = true;
            }else{
                $("#result").html("이미 사용중인 이메일 입니다.");
                $("#result").css('color','red');
                $("#result").css('visibility','visible');
            }
        },
        error:function(){
            alert("에러입니다");
        }
    });
};

function checkId2(){
    var id2 = $('#id2').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:'/join/idCheck2', //Controller에서 요청 받을 주소
        type:'post', //POST 방식으로 전달
        data:{userNickname:id2},
        success:function(cnt2){ //컨트롤러에서 넘어온 cnt값을 받는다
            if (cnt2 == 0){
                $("#result2").html("사용가능한 닉네임 입니다.");
                $("#result2").css('color','blue');
                $("#result2").css('visibility','visible');
                flag3 = true;
            }else{
                $("#result2").html("이미 사용중인 닉네임 입니다.");
                $("#result2").css('color','red');
                $("#result2").css('visibility','visible');
            }
        },
        error:function(){
            alert("에러입니다");
        }
    });
};
