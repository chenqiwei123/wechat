<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/3/18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>项目法人首页</title>
    <style type="text/css">
        div{
            color: white;
            font-weight: 700;
            border-radius: 100px;
            line-height: 300px;
            width: 900px;
            height: 300px;
            font-size: 5em;
            display: block;
            text-align: center;
            margin-top: 100px;
            background-color: blue;
            margin-left: 30px;
        }
    </style>
</head>
<body style="background-color: #7fff89;">
<h1 style="font-size: 6em;display: block;text-align: center;margin:180px;">主管部门首页</h1>
<div>前期工作管理</div>
<div>前期工作清单</div>
<div onclick="view()">统计展示</div>
</body>
</html>
<script type="text/javascript">
    function view() {
        window.location.href="View/view.jsp";
    }
</script>
