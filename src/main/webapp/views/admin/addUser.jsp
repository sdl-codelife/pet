<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.sdl.entity.UserInfo" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">添加用户</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="addUser.action?pageUtil.pageNo=1" method="post"
                  style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户类型：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.userType" class="layui-input layui-disabled"
                               value="${user.userType}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户ID：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.userId" required lay-verify="required" placeholder="请输入ID"
                               autocomplete="off" class="layui-input ">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user.userName" required lay-verify="required" placeholder="请输入用户名"
                               autocomplete="off" class="layui-input ">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="user.userPassword" required lay-verify="required"
                               placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别：</label>
                    <div class="layui-input-block">
                        <input type="radio" name="userInfo.userSex" value="男" title="男" checked="">
                        <input type="radio" name="userInfo.userSex" value="女" title="女">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.userTel" required lay-verify="required" placeholder="请输入电话"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.userQQ" required lay-verify="required" placeholder="请输入QQ"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block">
                        <textarea id="userInfo.userNote" name="userInfo.userNote" placeholder="请输入内容"
                                  class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
    //Demo
    layui.use(['form', 'element'], function () {
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交

    });
</script>
</body>
</html>