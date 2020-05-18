<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>项目投资监管微信平台</title>
    <style type="text/css">
        body{
            background: #1f1f2b;
            color: #fff;
        }
        .box{
            width: 100%;
            height: 1700px;
            /* margin: 150px auto; */
            /* padding: 30px; */
            background: rgba(20, 195, 139, 0.22);
            box-shadow: 0px 0px 5px 0px #fff;
        /* border-radius: 40px;

         */
            }
            .content{
                background: rgba(17, 247, 162, 0.59);
                height: 1200px;
            }
            h3{
                margin: auto;
                width: 100%;
                height: 200px;
                line-height: 200px;
                color: green;
                font-size: 5em;
                text-align: center;
            }
            .controller{
                text-align: center;
                margin-top: 20px;
                padding-left: 20px;
                padding-top: 20px;
            }
            input{
                width: 400px;
                background: none;
                /* border-top: none; */
                border: none;
                border-bottom: inset;
                outline: none;
                /* border-bottom: 1px solid #968f8f; */
                color: #fff;
            }
            a{
                font-size: 4em;
                color: #999;
                margin-left: 20px;
            }
            button{
                width: 300px;
                font-size: 70px;
                background: #54a5a1;
                color: #fff;
                border: none;
                padding: 10px;
                border-radius: 65px;
                cursor: pointer;
                outline: none;
            }
            button:hover{
                box-shadow: 0px 0px 1px 1px #fff;
            }
</style>
</head>
<body>
<div class="box">
    <h3>【项目投资监管微信平台】</h3>
    <div class="content">
        <div class="controller" style="
    /* margin-top: 300px; */
    padding-top: 300px;
    font-size: 4em;
">邮箱号码:<input type="text" id="email"/></div>
        <div class="controller"><input type="text" id="code"/><a href="javascript:void(0)" id="getCode">获取验证码</a></div>
        <div class="controller" style="text-align:center"><button onclick="validate()" >登录</button></div>
    </div>
</div>
<script type="text/javascript">
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
                alert("Send Success！");
            }
        }
        xhr.send(null);
        timer();
    }
    function validate(){
        //ajax引擎（浏览器内部的小型浏览器）
        var xhr = new XMLHttpRequest();
        //相当于你打开浏览器输入需要访问的地址
        xhr.open("post","EmailLoginServlet?code="+document.getElementById("code").value,true);
        //监控请求状态 判断是否请求完成，回调函数，事件监听函数
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                alert(xhr.responseText);
            }
        }
        xhr.send(null);
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
</script>
</body>
</html>
