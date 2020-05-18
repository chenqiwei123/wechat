<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="User.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 1.3em;">
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
            <span class="aui-center-title">我的</span>
        </div>
        <a href="#" class="aui-navBar-item">设置</a>
    </header>
    <section class="aui-scrollView">
        <div class="aui-user">
            <div class="aui-user-cell" id="userInfo">
                <div class="aui-user-cell-logo">
                    <% UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");%>
                    <img src="<%=userInfo.getHeadimgurl()%>" alt="">
                </div>
                <div class="aui-user-cell-title">
                    <p><%=userInfo.getNickname()%></p>
                </div>
            <div class="aui-user-row"></div>
            </div>

        </div>
        <div class="aui-list-cell">
            <a class="aui-list-item" >
                <div class="aui-list-item-fl">
                    <i class="icon icon-item01"></i>
                    用户中心
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" style="font-size: 0.7em" id="myPower">
                    <i></i>
                    我的功能

                </div>
            </a>
        </div>
        <div class="divHeight"></div>
        <div class="aui-list-cell">
            <a class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item02"></i>
                    我的消息
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" id="myMessage">
                    <i></i>
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item03"></i>
                    总资产

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" style="font-size: 0.7em">
                    <i></i>
                    免费领取100万元保障

                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item04"></i>
                    余额

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" style="font-size: 0.7em">
                    <i></i>
                    1,815,121,29.45 元
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item05"></i>
                    项目库管理

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" id="projectSetting">
                    <i></i>
                </div>
            </a>
            <a href="javascript:;" class="aui-list-item">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item06"></i>
                    银行卡

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                </div>
            </a>
        </div>
        <div class="divHeight"></div>
        <div class="aui-list-cell">
            <a class="aui-list-item view1" >
                <div class="aui-list-item-fl">
                    <i class="icon icon-item07"></i>
                    统计总览

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" id="ProjectView1">
                    <i></i>
                </div>
            </a>
            <a class="aui-list-item view">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item08"></i>
                    可视化分析
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" id="ProjectView2">
                    <i></i>
                </div>
            </a>
            <a class="aui-list-item view" >
                <div class="aui-list-item-fl">
                    <i class="icon icon-item09"></i>
                    多维度报表

                </div>
                <div class="aui-list-item-fr aui-list-item-arrow" id="ProjectView3">
                    <i></i>
                </div>
            </a>
        </div>
        <div class="divHeight"></div>
        <div class="aui-list-cell">
            <a class="aui-list-item report">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item10"></i>
                    项目反馈
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                </div>
            </a>
            <a class="aui-list-item" id="kefu" href="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item11"></i>
                    联系客服
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                </div>
            </a>
            <a class="aui-list-item qqchart" href="https://qm.qq.com/cgi-bin/qm/qr?k=2QhKN1eGPu91tfuq_OW3eMosfn13xg0b">
                <div class="aui-list-item-fl">
                    <i class="icon icon-item12"></i>
                    加入我们
                </div>
                <div class="aui-list-item-fr aui-list-item-arrow">
                    <i></i>
                </div>
            </a>
        </div>
        <div class="divHeight"></div>
    </section>

</section>
</body>
<script src="Jquery/jquery.js"></script>
<script src="User/js/PersonalCenter.js"></script>
</html>
<script>
    $("#projectSetting").click(function () {
        location.href="proejctInfoServlet";
    });
    $("#kefu").click(function () {
        location.href="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes";
    });
    $("#userInfo").click(function () {
        // location.href="http://www.runwsh.com/chen/personaluserinfoservlet"
        // $.ajax({
        //     url:"personaluserinfoservlet",
        //     async:false,
        //     type:"post",
        //     success:function (data) {
        //         alert(data);
        //     }
        // });
        location.href="personaluserinfoservlet";
    });
    // $("#qqchat").click(function () {
    //     location.href="https://qm.qq.com/cgi-bin/qm/qr?k=2QhKN1eGPu91tfuq_OW3eMosfn13xg0b";
    // });
    $("#myPower").click(function () {
        $(this).attr("href","myPower");
    });
    $("#ProjectView1").click(function () {
        $(this).attr("href","View");
        $.ajax({url:"View",async:false,type:"POST"});
        location.href="View";
    });
    $("#ProjectView2").click(function () {
        location.href="View1Servlet";
        $(this).attr("href","View1Servlet");
    });
    $("#ProjectView3").click(function () {
        location.href="View1Servlet";
        $(this).attr("href","View1Servlet");
    });
    $("#myMessage").click(function () {
        location.href="myMessage";
        $(this).attr("href","myMessage");
        $.ajax({url:"myMessage",async:false,type:"post"});
        // location.href="http://www.runwsh.com/chen/myMessage";
    });
</script>