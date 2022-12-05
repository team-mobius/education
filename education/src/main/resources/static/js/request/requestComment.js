console.log(1,"success");

let requestNumber = [[${request.requestNumber}]];
console.log(requestNumber);

$("button.reply_write_button").on("click",function () {
    let requestCommentContent = $("input[name='requestCommentContent']").val();
    let userNumber = 0;


    requestCommentService.add({
        requestCommentContent : requestCommentContent,
        userNumber : userNumber,
        requestNumber : requestNumber
    },function () {

    })

})
