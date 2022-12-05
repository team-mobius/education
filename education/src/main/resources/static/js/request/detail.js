console.log("success");

let requestCommentService = (function(){
    function add(requestComment, callback, error) {
        $.ajax({
            url:"/comment/new",
            type:"post",
            data: JSON.stringify(requestComment),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                callback(result);
            },
            error:function (a,b,c) {
                if(error){
                    error(a,b,c)
                }
            }
        });
    }

    function getList(requestCommentNumber,callback,error){
        $.ajax({
            url : "/comment/list/" +requestNumber,
            success:function(requestComments){
                if(callback){
                    callback(requestComments);
                }
            }
        })
    };

    function read(requestCommentNumber, callback, error) {
        $.ajax({
            url:"/comment/" +requestCommentNumber,
            type:"get",
            success:function (requestComment) {
                console.log(requestComment);
            }
        })
    };

    function remove(requestCommentNumber,callback,error) {
        $.ajax({
            url : "/comment/"+requestCommentNumber,
            type: "delete",
            success:function (requestComment) {
                if(callback){
                    callback();
                }
            }
        })
    }

    function modify(requestComment,callback,error) {
        $.ajax({
            url: "/comment/modify",
            type:"post",
            data:JSON.stringify(requestComment),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if(callback){
                    callback();
                }
            }
        })
    }

    return{add:add , read:read, remove: remove , modify:modify, getList:getList }
})();