<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/3/18
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>项目法人首页</title>
    <style type="text/css">
        .div{
            color: white;
            border-radius: 100px;
            line-height: 300px;
            width: 900px;
            height: 300px;
            font-size: 1.5em;
            display: block;
            text-align: center;
            margin-top: 100px;
            background-color: blue;
            margin-left: 30px;
        }
    </style>

    <link href="homepage/css/zzsc.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="homepage/js/jquery-1.9.1.min.js"></script>

</head>

<body style="height:1750px;background-color: aquamarine;">
<div style="width:980px;height:350px;line-height:350px;color:blue;font-size: 6em;display: block;text-align: center;">项目法人首页<div>
<div onclick="projectApply()" class="div">项目申请</div>
<div onclick="projectInfo()" class="div">项目申请情况</div>
<div onclick="view()" class="div">统计展示</div>
</body>
<div id="rightArrow"><a href="javascript:;" title="在线客户"></a></div>
<div id="floatDivBoxs">
    <div class="floatDtt">在线客服</div>
    <div class="floatShadow">
        <ul class="floatDqq">
            <li style="padding-left:0px;"><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes"><img src="homepage/images/qq.png" align="absmiddle">&nbsp;&nbsp;在线客服1号</a></li>
            <li style="padding-left:0px;"><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes"><img src="homepage/images/qq.png" align="absmiddle">&nbsp;&nbsp;在线客服2号</a></li>
            <li style="padding-left:0px;"><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3624026656&site=qq&menu=yes"><img src="homepage/images/qq.png" align="absmiddle">&nbsp;&nbsp;在线客服3号</a></li>
        </ul>
        <div class="floatDtxt">热线电话</div>
        <div class="floatDtel"><img src="homepage/images/online_phone.jpg" width="155" height="45" alt=""></div>
    </div>
    <div class="floatDbg"></div>
</div>
<script type="text/javascript" src="homepage/js/zzsc.js"></script>
</body>
</html>
<script type="text/javascript">
    function view() {
        window.location.href="View";
    }
    function projectApply() {
        window.location.href="projectServlet";
    }
    function projectInfo() {
        window.location.href="proejctInfoServlet";
    }
</script>
