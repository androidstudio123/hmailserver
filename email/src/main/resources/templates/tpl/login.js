// request: function () {
//
//     $.ajax({
//
//     })
// }

$("#login").on("click",function(e){
    // var radioValue = $('input:radio[name="kind"]:checked').val();
    // var formData=$("#login").serialize();

    $.ajax({
        url:"/login",
        type:"post",
        data:{"username":$("#username").val(),"password":$("#password").val()},
        dataType:"json",
        success:function(list){
            if("true"==list.flag){
                window.location.href = "http://www.baidu.com";
            }else{
                alert("用户名或者密码不对");
            }
        }
    })
})

 function(aaa){
    $.ajax({
        url:"/login",
        type:"post",
        data:{"username":$("#username").val(),"password":$("#password").val()},
        dataType:"json",
        success:function(list){
            if("true"==list.flag){
                window.location.href = "http://www.baidu.com";
            }else{
                alert("用户名或者密码不对");
            }
        }
}
