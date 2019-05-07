$(function () {
$("#deleteorder").on("click",function(e){
    // var radioValue = $('input:radio[name="kind"]:checked').val();
    // var formData=$("#login").serialize();
var id=$("#deleteorder").val();
var login_id=$("#login_id").val();
    $.ajax({
        url:"/deleteorder",
        type:"POST",
        data:{"orderid":$("#deleteorder").val()},
        dataType:"json",
        success:function(){
            alert("删除成功");
                location.href = "/goorder?login_id="+login_id;

        }
    })
})

 // function(aaa){
 //    $.ajax({
 //        url:"/login",
 //        type:"post",
 //        data:{"username":$("#username").val(),"password":$("#password").val()},
 //        dataType:"json",
 //        success:function(list){
 //            if("true"==list.flag){
 //                window.location.href = "http://www.baidu.com";
 //            }else{
 //                alert("用户名或者密码不对");
 //            }
 //        }
})
