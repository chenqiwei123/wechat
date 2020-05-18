<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/1/6
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
      $(function(){
        $("button").click(function () {
          var url="OrCodeShowServlet";
          $.get(url,function (ticket) {
            var src="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
            alert(src);
            $("button").after("<img src=\""+src+"\"/>");
          });
        });
      });
    </script>
  </head>
  <body>
  <button id="button">生成二维码</button><br/>
  </body>
</html>
