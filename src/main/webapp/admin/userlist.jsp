<%--
  Created by IntelliJ IDEA.
  User: sdl
  Date: 2019/10/24
  Time: 10:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="iframe-h">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
</head>

<body>
<div class="wrap-container clearfix">
    <div class="column-content-detail">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <div class="layui-inline tool-btn">
                    <button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="article-add.html"><i class="layui-icon">&#xe654;</i></button>
                    <button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="article-add.html"><i class="iconfont">&#xe656;</i></button>
                </div>
                <div class="layui-inline">
                    <input type="text" name="title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                </div>
                <button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
            </div>
        </form >
        <div class="layui-form" id="table-list">
            <table class="layui-table" lay-even lay-skin="nob">
                <colgroup>
                    <col class="hidden-xs" width="50">
                    <col class="hidden-xs" width="80">
                    <col class="hidden-xs" width="100">
                    <col class="hidden-xs" width="50">
                    <col class="hidden-xs" width="100">
                    <col width="80">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>

                    <th>ID</th>
                    <th>用户类型</th>
                    <th>用户名</th>
                    <th>性别</th>
                    <th>电话号码</th>
                    <th>QQ</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="info" items="${infoList}">
                <tr>
                        <td><c:out value="${info.userId}"/></td>
                        <td><c:out value="${info.userType}"/></td>
                        <td><c:out value="${info.userName}"/></td>
                        <td><c:out value="${info.userSex}"/></td>
                        <td><c:out value="${info.userTel}"/></td>
                        <td><c:out value="${info.userQQ}"/></td>
                    <td>
                        <div class="layui-inline">
                            <a href="userinfo.action?userId=${info.userId}&userName=${info.userName}" class="layui-btn layui-btn-small layui-btn-normal go-btn"><i class="layui-icon">&#xe642;</i></a>
                            <a href="delUser.action?user.userId=${info.userId}&user.userType=${info.userType}" class="layui-btn layui-btn-small layui-btn-normal del-btn"><i class="layui-icon">&#xe640;</i></a>

                        </div>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="page-wrap">
                <ul class="pagination">
                    <li class="disabled"><span>«</span></li>
                    <li class="active"><span>1</span></li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">»</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
