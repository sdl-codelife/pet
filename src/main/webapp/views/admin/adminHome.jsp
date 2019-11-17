<%--
Created by IntelliJ IDEA.
User: sdl
Date: 2019/10/22
Time: 8:26 下午
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    0
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>宠物医院</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
</head>
<body>
<div class="main-layout" id='main-layout'>
    <!--侧边栏-->
    <div class="main-layout-side">
        <div class="m-logo">
        </div>
        <ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;"><i class="iconfont">&#xe607;</i>管理员管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="toaddUser.action?user.userType=admin" target="iframe"><span class="l-line"></span>增加管理员</a>
                    </dd>
                    <dd><a href="userlist.action?user.userType=admin&pageUtil.pageNo=1" target="iframe"><span
                            class="l-line"></span>查看管理员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="iconfont">&#xe608;</i>医生管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="toaddUser.action?user.userType=doctor" target="iframe"><span class="l-line"></span>增加医生</a>
                    </dd>
                    <dd><a href="userlist.action?user.userType=doctor&pageUtil.pageNo=1" target="iframe"><span
                            class="l-line"></span>查看医生</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="iconfont">&#xe608;</i>用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="toaddUser.action?user.userType=user" data-text="查看用户" target="iframe"><span
                            class="l-line"></span>增加用户</a></dd>
                    <dd><a href="userlist.action?user.userType=user&pageUtil.pageNo=1" target="iframe"><span
                            class="l-line"></span>查看用户</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a href="userinfo.action?userInfo.userId=${user.userId}&userInfo.userName=${user.userName}"
                   target="iframe"><i
                        class="iconfont">&#xe606;</i>个人信息</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" data-url="system.html" data-id='6' data-text="系统设置"><i
                        class="iconfont">&#xe60b;</i>系统设置</a>
            </li>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="main-layout-container">
        <!--头部-->
        <div class="main-layout-header">
            <div class="menu-btn" id="hideBtn">
                <a href="javascript:;">
                    <span class="iconfont">&#xe60e;</span>
                </a>
            </div>
            <ul class="layui-nav" lay-filter="rightNav">
                <li class="layui-nav-item"><a href="javascript:;" data-url="email.html" data-id='4' data-text="邮件系统"><i
                        class="iconfont">&#xe603;</i></a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="admin-info.html" data-id='5' data-text="个人信息">${user.userName}</a>
                </li>
                <li class="layui-nav-item"><a href="logout.action">退出</a></li>
            </ul>
        </div>
        <!--主体内容-->
        <div class="main-layout-body">
            <!--tab 切换-->
            <div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
                <ul class="layui-tab-title">
                    <li class="layui-this welcome">管理员功能</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
                        <!--1-->

                        <iframe src="userinfo.action?userInfo.userId=${user.userId}&userInfo.userName=${user.userName}"
                                width="100%" height="100%" name="iframe" scrolling="auto" class="iframe"
                                framborder="0"></iframe>
                        <!--1end-->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--遮罩-->
    <div class="main-mask">

    </div>
</div>
<script type="text/javascript">

</script>

<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
<script src="static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>

