<%--<%@ page import="net.sf.json.JSONObject" %>--%>
<!-- JSTL 函数 包含一系列标准函数，大部分是通用的字符串处理函数-->
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>--%>

<%--<!-- JSTL 核心标签库 -->--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<%--<!-- JSTL 格式化标签 用来格式化并输出文本、日期、时间、数字 -->--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <META content="IE=11.0000" http-equiv="X-UA-Compatible">

    <META charset="UTF-8">
    <TITLE>我的项目申请信息</TITLE>
    <META name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">

    <META name="apple-mobile-web-app-capable" content="yes">
    <META name="apple-mobile-web-app-status-bar-style" content="black">
    <META name="format-detection" content="telephone=no">
    <LINK href="homepage/css/style.css"
          rel="stylesheet" type="text/css">
    <META name="GENERATOR" content="MSHTML 11.00.10570.1001">
    <style type="text/css">
        tr{
            display: block;
            width: 400px;
        }
        td{
            width: 150px;
            font-size: 0.8em;
        }
        table{
            display: block;
            background-color: aquamarine;
            border-radius: 20px;
        }
    </style>
</HEAD>
<BODY id="body">
<SECTION class="aui-flexView">
    <HEADER class="aui-navBar aui-navBar-fixed b-line">
        <DIV class="aui-center">
            <p style="display:block;line-height:60px;text-align:center;font-size:2em;">
                我的项目申请信息
            </p>
        </DIV>
    </HEADER>
    <SECTION class="aui-scrollView">
        <DIV class="aui-find-body">

            <DIV class="aui-find-news" id="myproject">
                <H2 id="prjectInfo">项目信息</H2>
                <%--<button value="展示" type="button" id="button">展示</button>--%>
            </DIV>
        </DIV>
    </SECTION>
</SECTION>
</BODY>
</HTML>
<script src="Jquery/jquery.js"></script>
<script>
    var obj=0;
    $("#myproject").on('click',function () {
        if (obj>0){
            return;
        }
        $.ajax({
            url: "GetProjectInfoServlet",
            type: "post",
            async:false,
            success: function (e) {
                $("#prjectInfo").after("");
                $("#prjectInfo").after(e);
            }
        });
    });
    $("#myproject").click();
    $(".unpass").click(function () {
        // $(this).attr("href","unpass");
        $.ajax({
            url:"unpass",
            async:false,
            type:"post",
            data:{
                openid:$(this).getAttribute("data-openid"),
                id:$(this).getAttribute("data-project"),
                content:"未通过审核"
            },
            success:function () {
                alert("未通过审核");
            }
        });
        // location.href="unpass";
    });
    $(".pass").click(function () {
        // $(this).attr("href","unpass");
        $.ajax({
            url:"pass",
            async:false,
            type:"post",
            data:{
                openid:this.getAttribute("data-openid"),
                id:this.getAttribute("data-project"),
                content:"已通过审核"
            },
            success:function () {
                alert("通过审核！");
            }
        });
        // location.href="unpass";
    });
    $(".ww").click(function () {
        obj=obj+1;
        if ($(this).find("table").css('display')=='none') {
            $(this).find("table").css('display', 'block');
            // $("#partProjectInfo").css('display', 'none');
        }
        else {
            $(this).find("table").css('display', 'none');
            // $("#partProjectInfo").css('display', 'none');
        }
    });
</script>

