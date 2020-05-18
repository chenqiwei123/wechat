$(document).ready(function(){
    $("#chenqiwei").click(function(){
        $("#options").hide();
    });
    $("#cqw").click(function(){
        $("#optionss").hide();
    });
    $("#login").click(function () {
        var options=$("#select option:selected");
        $.ajax({
            url:'LoginServlet',
            type:'post',
            data:{
                email:$("#email1").val(),
                password:$("#password3").val(),
                type:options.text()
            },
            success:function (result) {
                alert(result)
            }
        });
    });
    $("#wechat").click(function () {
        // var src1="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
        if($(".showCode").is(':hidden')||$(".showCode").length==0){
                $("#login").after("<img class='showCode' src=\"UserLogin/images/wechat.png\"/>");
        }
        else {
            $(".showCode").remove();
        }
    });
    $(".showCode").click(function () {
        // var src1="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
        if($(this).is(':hidden')||$(this).length==0){
            $("#login").after("<img class='showCode' src=\"UserLogin/images/wechat.png\"/>");
        }
        else {
            $(this).remove();
        }
    });
    $("#forgetPassword").click(function () {
        location.href="ForgetPasswordServlet";
    });
    //注册验证格式
    $("#register").click(function () {
        var options=$("#select option:selected");
        if (!$("#fr").is(":checked")&&!$("#zg").is(":checked")&&!$("#fg").is(":checked")){
            alert("您未选择登录类型！");
            return;
        }
        if ($("#username").val()==""){
            alert("用户名不能为空，不过我不会保存你写的用户名。。哈哈");
            return;
        }
        if($("#email").val()=="")
        {
            alert("邮箱不能为空");
            return;
        }else{
        var email=$("#email").val();
        if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
        {
            alert("格式不正确！请重新输入");
            // $("#email").focus();
            return;
        }
        }
        if ($("#password").val().length<=6){
            alert("密码设置太简单了");
            // $(this).focus;
            return;
        }
        if ($("#password").val()!=$("#password2").val()){
            alert("两次密码设置不一致，请重新设置");
            // $(this).focus();
            return;
        }
        var options=$("#select option:selected");
        $.ajax({
            url:"EmailLoginServlet",
            type:"post",
            cache:false,
            async:false,
            data: {
                username:$("#username").val(),
                email: $("#email").val(),
                password:$("#password").val(),
                type:$("#cqw").find("option:selected").text(),
                code:$("#code").val()
            },
            success:function (data) {
                alert("注册成功！");
            }
        })

    });
});
document.querySelector('.img__btn').addEventListener('click', function() {
    document.querySelector('.content').classList.toggle('s--signup')
})
var obj = document.getElementById("getCode");
var flag = 10;
//注册点击事件
obj.onclick=function(){
    if(flag<10){
        return;
    }
    //ajax引擎（浏览器内部的小型浏览器）
    var xhr = new XMLHttpRequest();
    //相当于你打开浏览器输入需要访问的地址
    xhr.open("post","EmailCheckServlet?email="+document.getElementById("email").value,true);
    //监控请求状态 判断是否请求完成，回调函数，事件监听函数
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4&&xhr.status==200){
            alert("验证码已发送，请注意查收！");
        }
    }
    xhr.send(null);
    timer();
}
function timer(){
    flag--;
    obj.innerHTML=flag+"秒重获";
    if(flag==0){
        obj.innerHTML="获验证码";
        flag =10;
    }else{
        setTimeout("timer()",1000);
    }
}