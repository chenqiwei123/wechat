<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/2/21
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="User.UserInfo" %>
<%@ page import="User.UserLoginInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 1.5em;">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <title>个人中心</title>
    <link href="User/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<section class="aui-flexView">
    <header class="aui-header aui-navBar aui-navBar-fixed">
        <a href="#" class="aui-navBar-item">
            <i class="icon icon-return"></i>
        </a>
        <div class="aui-center">
            <span class="aui-center-title">我的信息</span>
        </div>
    </header>
    <section class="aui-scrollView">
        <div class="aui-list-cell" style="margin-top: 30px;">
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item01"></i>
                    我的头像
                </div>
                <%
                    UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
                    UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLogin");
                %>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <img src="<%=userInfo.getHeadimgurl()%>" style="width: 25%;">
                </div>
            </a>
        </div>
        <div class="aui-list-cell">
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item01"></i>
                    我的昵称
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <%=userInfo.getNickname()%>
                </div>
            </a>
        </div>
        <div class="aui-list-cell">
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item02"></i>
                    性别

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <%=userInfo.getSex()%>
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item03"></i>
                    微信订阅

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <%=userInfo.getSubscribe()%>

                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item04"></i>
                    我的余额

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    1,115,121,29.45 元
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item05"></i>
                    国籍
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <%=userInfo.getCountry()%>
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item06"></i>
                    居住地址

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                    <%=userInfo.getProvince()%>省<%=userInfo.getCity()%>市

                </div>
            </a>
        </div>
        <div class="aui-list-cell" id="myMessage">
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item07"></i>
                    我的消息

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                </div>
            </a>
        </div>
    </section>
</section>
</body>
<script src="Jquery/jquery.js"></script>
<script src="User/js/PersonalCenter.js"></script>
</html>
<script>
    $("#myMessage").click(function () {
        $.ajax({url:"myMessage",async:false,type:"post"});
        // location.href="http://www.runwsh.com/chen/myMessage";
    });
    $("#myMessage").click(function () {
        location.href="myMessage";
        $(this).attr("href","myMessage");
        $.ajax({url:"myMessage",async:false,type:"post"});
        // location.href="http://www.runwsh.com/chen/myMessage";
    });
</script>
