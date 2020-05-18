<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/3/19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目申请</title>
    <link rel="stylesheet" href="homepage/css/Bootstrap.css">
    <script src="homepage/js/jquery.js"></script>
    <script src="homepage/js/bootstrap.js"></script>
</head>
<style>
    #step1{
        display:block;
    }
    #step2,#step3{
        display: none;
    }
    #step1,#step2,#step3{
        text-align: center;
        position: absolute;
        width: 100%;
    }
    .panel-body{
        height: 1500px;
    }
    .panel,.panel-body{
        height: 1500px;
    }
    input{
        font-size: 4em;
        height: 80px;
        margin: 0 71.1px;
        width: 85%;
        display: block;
        text-align: center;
        border: solid;
        border-radius: 30px;
    }
    p{
        font-size:4em;
    }
    .panel-title{
        font-size:4em;
    }
    button{
        font-size: 2em;
        margin-top:50px;
        margin-left:50px;
    }
    select{
        width:805.8px;
        height:80px;
        font-size:4em;
        display:block;
        border-radius:50px;
    }
</style>
<body style="background-color: gray;">
<!-- 下一步，下一步 -->
<div id="step1" >
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">项目基本信息</h3>
        </div>
        <div class="panel-body" style="height: 1500px;">
            <p>项目名称：</p><input type="text" name="p1_name" id="p1_name"/>
            <p>项目地址：</p><input type="text" name="p1_address" id="p1_address"/>
            <p>建设性质：</p>
            <select name="jsxz" id="jsxz" class="text" style="display: block;text-align: center;">
                <option value="" selected="selected">请选择</option>
                <option value="新建">新建</option>
                <option value="扩建">扩建</option>
                <option value="改建和技术改造">改建和技术改造</option>
                <option value="单纯建造生活设施">单纯建造生活设施</option>
                <option value="迁建">迁建</option>
                <option value="恢复">恢复</option>
                <option value="单纯购置">单纯购置</option>
                <option value="其它">其它</option>
            </select>
            <p>行业编码：</p><input type="text" name="p1_code" id="p1_code"/>
            <p>建设时间：</p><input type="text" name="p1_time" id="p1_time"/>
            <p>行政区划代码：</p><input type="text" name="p1_code2" id="p1_code2"/>
            <p>建设单位项目编号：</p><input type="text" name="p1_number" id="p1_number"/>
            <button type="button" class="btn btn-primary">上一步</button>
            <button type="button" class="btn btn-success" onclick="getnext('step2')" >下一步</button>
        </div>
    </div>
</div>
<div id="step2">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">建设单位信息</h3>
        </div>
        <div class="panel-body" style="height: 1500px;">
            <p>单位名称：</p><input type="text" name="p2_name" id="p2_name"/>
            <p>组织机构代码：</p><input type="text" name="p2_code" id="p2_code"/>
            <p>单位联系电话：</p><input type="text" name="p2_tel" id="p2_tel"/>
            <p>项目联系人：</p><input type="text" name="p2_person" id="p2_person"/>
            <p>项目联系人电话：</p><input type="text" name="p2_phone" id="p2_phone"/>
            <p>项目联系人邮箱：</p><input type="text" name="p2_email" id="p2_email"/>
            <p>单位地址：</p><input type="text" name="p2_adress" id="p2_adress"/>
            <button type="button" class="btn btn-primary" onclick="getnext('step1')">上一步</button>
            <button type="button" class="btn btn-success" onclick="getnext('step3')">下一步</button>
        </div>
    </div>
</div>
<div id="step3">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">信息说明</h3>
        </div>
        <div class="panel-body" style="height: 1500px;">
                <textarea name="Text1" cols="130" rows="8" placeholder="还有想说明的，在这里备注。" style="height:300px;margin-top:50px;width: 60%;" id="p3_info"></textarea>
                <button type="button" class="btn btn-primary" onclick="getnext('step2')">上一步</button>
                <button type="button" class="btn btn-success" id="ProjectSubmit">提交</button>
        </div>
    </div>
</div>
<!-- 下一步，下一步 -->
</body>
<script>
    function getnext(i){
        var sz=new Array("step1","step2","step3");
        for(var j=0;j<sz.length;j++){
            if(i==sz[j]){
                document.getElementById(i).style.display="block";
            }else{
                document.getElementById(sz[j]).style.display="none";
            }
        }
    }
</script>
<script>
    $("#ProjectSubmit").click(function () {
        var p1_name=$("#p1_name").val();
        var p1_address=$("#p1_address").val();
        var value=$("#jsxz").find("option:selected").text();
        var p1_code=$("#p1_code").val();
        var p1_time=$("#p1_time").val();
        var p1_code2=$("#p1_code2").val();
        var p1_number=$("#p1_number").val();
        var p2_name=$("#p2_name").val();
        var p2_code=$("#p2_code").val();
        var p2_tel=$("#p2_tel").val();
        var p2_person=$("#p2_person").val();
        var p2_phone=$("#p2_phone").val();
        var p2_email=$("#p2_email").val();
        var p2_adress=$("#p2_adress").val();
        var p3_info=$("#p3_info").val();
        $.ajax({
            url:"projectInfo",
            type:"post",
            cache:false,
            async:false,
            data:{
                p1_name:p1_name,
                p1_address:p1_address,
                p1_code:p1_code,
                p1_time:p1_time,
                p1_code2:p1_code2,
                p1_number:p1_number,
                p2_name:p2_name,
                p2_code:p2_code,
                p2_tel:p2_tel,
                p2_person:p2_person,
                p2_phone:p2_phone,
                p2_email:p2_email,
                p2_adress:p2_adress,
                p3_info:p3_info,
                value:value
            },
            success:function () {
                alert("项目申请成功！");
            }
        });
        //相当于你打开浏览器输入需要访问的地址

    });
</script>
</html>