var flag1 = false;
var flag2 = false;


function checkId3(){
    var id3 = $('#id3').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:'/join/idCheck3', //Controller에서 요청 받을 주소
        type:'post', //POST 방식으로 전달
        data:{teacherEmail:id3},
        success:function(cnt3){ //컨트롤러에서 넘어온 cnt값을 받는다
            if (cnt3 == 0){
                $("#result3").html("사용가능한 이메일 입니다.");
                $("#result3").css('color','blue');
                $("#result3").css('visibility','visible');
                flag3 = true;
            }else{
                $("#result3").html("이미 사용중인 이메일 입니다.");
                $("#result3").css('color','red');
                $("#result3").css('visibility','visible');
            }
        },
        error:function(){
            alert("에러입니다");
        }
    });
};

function checkFlag() {
    if(flag1 == false){
        alert("입력란을 확인해 주세요")
        return false;
    }else {
        alert("회원가입 완료")
        document.teacherForm.submit();
    }

}
function chkPW() {
    var pw = $("#password").val();
    // var underPw = $("#under-password");
    var num = pw.search(/[0-9]/g);
    var eng = pw.search(/[a-z]/ig);

    var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if (pw.length == 0) {
        $('#passwordResult').html('비밀번호를 입력해주세요.');
        $('#passwordResult').css('color', 'red');
        $('#passwordResult').css('visibility', 'visible');
        flag3 = false;
    } else if (pw.length < 8 || pw.length > 20) {
        $('#passwordResult').html('8자리 ~ 20자리 이내로 입력해주세요.');
        $('#passwordResult').css('color', 'red');
        $('#passwordResult').css('visibility', 'visible');
        flag3 = false;
        // return false;
    } else if (pw.search(/\s/) != -1) {
        $('#passwordResult').html('비밀번호는 공백 없이 입력해주세요.');
        $('#passwordResult').css('color', 'red');
        $('#passwordResult').css('visibility', 'visible');
        flag3 = false;
        // return false;
    } else if (num < 0 || eng < 0 || spe < 0) {
        $('#passwordResult').html('영문,숫자, 특수문자를 혼합하여 입력해주세요.');
        $('#passwordResult').css('color', 'red');
        $('#passwordResult').css('visibility', 'visible');
        flag3 = false;
        // return false;
    } else {
        $('#passwordResult').html('사용 가능한 비밀번호 입니다.');
        $('#passwordResult').css('color', 'blue');
        $('#passwordResult').css('visibility', 'visible');
        flag3 = true;
        console.log("통과");
        // return true;
    }
}
function chkPW2() {
    var pw1 = $("#password").val();
    var pw2 = $("#passwordCheck").val();

    if (pw1 == pw2 && pw2.length >= 8 && pw2.length <= 20){
        $('#passowrdCheckResult').html('비밀번호가 일치합니다.');
        $('#passowrdCheckResult').css('color','blue');
        $('#passowrdCheckResult').css('visibility','visible');
        flag4 = true;
    } else {
        $('#passowrdCheckResult').html('다시 확인해주세요.');
        $('#passowrdCheckResult').css('color','red');
        $('#passowrdCheckResult').css('visibility','visible');
        flag4 = false;
    }
}

// var reg = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
// var txt = "aaaa";
//
// function () {
//     if( !reg.test(txt) ) {
//         alert("비밀번호 정규식 규칙 위반!!");
//         return false;
//     }
// }


// function checkId4(){
//     var id4 = $('#id4').val(); //id값이 "id"인 입력란의 값을 저장
//     $.ajax({
//         url:'/join/idCheck4', //Controller에서 요청 받을 주소
//         type:'post', //POST 방식으로 전달
//         data:{teacherName:id4},
//         success:function(cnt3){ //컨트롤러에서 넘어온 cnt값을 받는다
//             if (cnt2 == 0){
//                 $("#result3").html("사용가능한 닉네임 입니다.");
//                 $("#result3").css('color','blue');
//                 $("#result3").css('visibility','visible');
//                 flag3 = true;
//             }else{
//                 $("#result3").html("이미 사용중인 닉네임 입니다.");
//                 $("#result3").css('color','red');
//                 $("#result3").css('visibility','visible');
//             }
//         },
//         error:function(){
//             alert("에러입니다");
//         }
//     });
// };