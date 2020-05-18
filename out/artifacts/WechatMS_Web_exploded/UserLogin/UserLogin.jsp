<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>资产投资监管注册登录页面</title>
    <link rel="stylesheet" href="UserLogin/css/style.css" charset="UTF-8">
</head>
<body>
<div class="content">
    <div class="form sign-in">
        <h1 style="font-size: 5em;padding-top: 150px;color: darkviolet;">欢迎回来</h1>
        <label>
           <select id="chenqiwei">
                <option id="options">请选择登录类型</option>
                <option>项目法人</option>
                <option>主管部门</option>
                <option>发改部门</option>
            </select>
        </label>
        <label>
            <input type="text" placeholder="请输入您的邮箱号码" id="email1">
        </label>
        <label>
            <span></span>
            <input type="password" placeholder="请输入您的密码" id="password3">
        </label>
        <span class="forgetMe" id="forgetPassword">忘记密码？</span>
        <button type="button" class="submit" id="login">登 录</button>
        <button type="button" class="fb-btn" id="wechat" style="font-size: 2.7em;margin-top:60px;">使用 <span> 微信扫码</span> 帐号登录</button>
    </div>
    <div class="sub-cont">
        <div class="img">
            <div class="img__text m--up">
                <h2 style=" font-size: 2.7em;color: red;">还未注册？</h2>
                <p style="color: dodgerblue;font-size: 2.7em;">立即注册，发现机会！</p>
            </div>
            <div class="img__text m--in">
                <h2 style="font-size: 2.7em;color: red;">已有帐号？</h2>
                <p style="color: dodgerblue;font-size: 2.7em;">有帐号就登录吧，好久不见了！</p>
            </div>
            <div class="img__btn">
                <span class="m--up" style="font-size: 2.7em;">注 册</span>
                <span class="m--in" style="font-size: 2.7em;">登 录</span>
            </div>
        </div>
        <div class="form sign-up">
            <h2 style="font-size: 5em;padding-top:30px;color: darkviolet;">立即注册</h2>
            <label>
                <select id="cqw">
                    <option id="optionss">请选择注册类型</option>
                    <option id="fr">项目法人</option>
                    <option id="zg">主管部门</option>
                    <option id="fg">发改部门</option>
                </select>
            </label>
            <label>
                <input type="text" name="username" id="username" placeholder="请输入您的用户名" />
            </label>
            <label>
                <span></span>
                <input type="text" name="email" id="email" placeholder="请输入您的邮箱" />
            </label>
            <label>
                <span></span>
                <input type="password" name="password1" id="password" placeholder="请输入密码" />
            </label>
            <label>
                <span></span>
                <input type="password" name="password2" id="password2" placeholder="请再次输入密码" />
                <input type="text" name="checkCode" style="padding-top: 7px;float: left;font-size: 56px;width: 260px;display: block;margin: 55px 0 5px 0;" placeholder="输验证码" id="code" />
                <a href="javascript:void(0)" style="text-decoration: none;height: 82px;width: 50%;float: left;padding-top:6px;color:gray;margin:62px 0 0 0;" id="getCode">获验证码</a>
            </label>
            <button type="button" class="submit1" id="register" style="display: block;font-size: 2.7em;margin-top: 160px;">注 册</button>
        </div>
    </div>
</div>
</body>
</html>
<script src="Jquery/jquery.js"></script>
<script src="UserLogin/js/script.js"></script>
<script>
    $("#email").onblur(function () {
        if($("#email").val()=="")
        {
            alert("邮箱不能为空!");
            return;
        }else {
            var email = $("#email").val();
            if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
                alert(">>格式不正确,请重新输入!<<");
                // $("#email").focus();
                return;
            }
        }
    });
    $(document).ready(function(){
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
                alert("您未选择注册类型！");
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
                    alert(">>格式不正确,请重新输入!<<");
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
                type:"POST",
                cache:false,
                async:false,
                data: {
                    username:$("#username").val(),
                    email: $("#email").val(),
                    password:$("#password").val(),
                    type:$("#cqw").find("option:selected").text(),
                    code:$("#code").val()
                },
                success:function () {
                    alert("注册成功");
                }
            })
        });
    });
    document.querySelector('.img__btn').addEventListener('click', function() {
        document.querySelector('.content').classList.toggle('s--signup')
    })
    var obj = document.getElementById("getCode");
    var flag = 60;
    //注册点击事件
    obj.onclick=function(){
        if(flag<60){
            return;
        }
        //ajax引擎（浏览器内部的小型浏览器）
        var xhr = new XMLHttpRequest();
        var email=document.getElementById("email").value;
        //相当于你打开浏览器输入需要访问的地址
        xhr.open("post","EmailCheckServlet?email="+email,true);
        //监控请求状态 判断是否请求完成，回调函数，事件监听函数
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                alert("验证码已发送，请注意查收！"+email);
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
            flag =60;
        }else{
            setTimeout("timer()",1000);
        }
    }
</script>