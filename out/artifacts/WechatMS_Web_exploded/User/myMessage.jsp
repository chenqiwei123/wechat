<%--
  Created by IntelliJ IDEA.
  User: RunWsh
  Date: 2020/3/25
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">
<META charset="UTF-8">
<TITLE>消息中心</TITLE>
<META name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
<META name="apple-mobile-web-app-capable" content="yes">
<META name="apple-mobile-web-app-status-bar-style" content="black">
<META name="format-detection" content="telephone=no">
<LINK href="User/index_files/style.css" rel="stylesheet" type="text/css">
<SCRIPT src="User/index_files/jquery-3.3.1.min.js" type="text/javascript"></SCRIPT>
<SCRIPT src="User/index_files/tab.js" type="text/javascript"></SCRIPT>
<style type="text/css">
    .ww{
        display: block;
    }
</style>
<META name="GENERATOR" content="MSHTML 11.00.10570.1001"></HEAD>
<BODY>
<SECTION class="aui-flexView">
    <HEADER class="aui-navBar aui-navBar-fixed">
        <A class="aui-navBar-item" href="javascript:;">
            <I class="icon icon-return"></I>
        </A>
    <DIV class="aui-center">
        <SPAN class="aui-center-title">消息中心</SPAN>
    </DIV>
        <A class="aui-navBar-item" href="javascript:;">
            <I class="icon icon-more"></I>
        </A>
    </HEADER>
<SECTION class="aui-scrollView">
    <DIV class="aui-tab" data-ydui-tab="">
        <UL class="tab-nav">
            <LI class="tab-nav-item tab-active"><A href="javascript:;">系统通知</A></LI>
            <LI class="tab-nav-item"><A href="javascript:;">项目信息</A></LI>
            <LI class="tab-nav-item"><A href="javascript:;">审核信息</A></LI>
        </UL>
        <DIV class="tab-panel" style="display: block;">
            <DIV class="tab-panel-item tab-active">
                <A class="aui-flex b-line" href="javascript:;">
                <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-001.png"></DIV>
                <DIV class="aui-flex-box">
                    <H3>我的客服</H3>
                    <P>您在2020年5月2号19:32反馈的信息已被处理</P></DIV></A>
                <A class="aui-flex b-line" href="javascript:;">
                <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-002.png"><SPAN
                        class="aui-look-tag">3</SPAN></DIV>
                <DIV class="aui-flex-box">
                    <H3>项目信息</H3>
                    <P>您在2020年5月6号12:12申请的项目信息填写成功</P></DIV></A>
                <A class="aui-flex b-line" href="javascript:;">
                    <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-003.png"><SPAN
                            class="aui-look-tag">3</SPAN></DIV>
                    <DIV class="aui-flex-box">
                        <H3>项目审批</H3>
                        <P>恭喜您在2020年5月6号12:12申请的项目审核通过！</P>
                    </DIV>
                </A>
                <A class="aui-flex b-line"
                                                                             href="javascript:;">
                    <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-004.png"></DIV>
                    <DIV class="aui-flex-box">
                        <H3>审核进度</H3>
                        <P>您在2020年4月26号16:36申请的项目正在审核中。</P></DIV></A>
                <A class="aui-flex b-line" href="javascript:;">
                    <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-005.png"><SPAN
                            class="aui-look-tag">1</SPAN></DIV>
                    <DIV class="aui-flex-box">
                        <H3>反馈信息</H3>
                        <P>您在2020年4月12号20:46反馈信息：项目申请失败，不能提交申请！</P></DIV></A>
            </DIV>
            <DIV class="tab-panel-item">
                <A class="aui-flex b-line" href="javascript:;">
                <DIV class="aui-look-img"><IMG alt="" src="User/index_files/icon-img-002.png"><SPAN
                        class="aui-look-tag">3</SPAN></DIV>
                <DIV class="aui-flex-box">
                    <H3>项目预警</H3>
                    <P>您的项目审核时间还有三天要被超时被处理了。</P></DIV></A>

            </DIV>
            <DIV class="tab-panel-item">
                <A class="aui-flex b-line" href="javascript:;">
                <DIV class="aui-look-img">
                    <IMG alt="" src="User/index_files/icon-img-002.png"><SPAN
                        class="aui-look-tag">3</SPAN></DIV>
                <DIV class="aui-flex-box">
                    <H3>项目超时</H3>
                    <P>您在2020年4月05号15:54申请的项目已经超时了!</P></DIV>
            </A>
            </DIV>
        </DIV>
        <div style="display: none;width: 80%;margin:50px auto;text-align: center;" id="myMessage"></div>
    </DIV>
</SECTION>
</SECTION>
</BODY></HTML>
<script>
    $(".aui-flex").click(function () {
        if ($(this).css('display')=='none') {
            $(this).css('display', 'flex');
            $("#aa").hide();
            // $("#partProjectInfo").css('display', 'none');
        }
        else {
            $(this).css('display', 'none');
            $(this).text($(this).find("p").text());
            // $("#partProjectInfo").css('display', 'none');
        }
    });
</script>