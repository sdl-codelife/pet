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
        <li class="layui-this">更新宠物信息</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form"
                  action="updatePet.action?pet.petId=${pet.petId}&pet.userId=${pet.userId}&pageUtil.pageNo=1"
                  method="post"
                  style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="pet.petName" required lay-verify="required" placeholder="请输入宠物姓名"
                               autocomplete="off" class="layui-input " value="${pet.petName}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物种类：</label>
                    <div class="layui-input-block">
                        <input type="text" name="pet.petBreed" required lay-verify="required" placeholder="请输入宠物种类"
                               autocomplete="off" class="layui-input " value=${pet.petBreed}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物性别：</label>
                    <c:if test="${pet.petSex=='母'}">
                        <div class="layui-input-block">
                            <input type="radio" name="pet.petSex" value="男" title="男">
                            <input type="radio" name="pet.petSex" value="母" title="母" checked="">
                        </div>
                    </c:if>
                    <c:if test="${pet.petSex=='公'}">
                        <div class="layui-input-block">
                            <input type="radio" name="pet.petSex" value="公" title="公" checked="">
                            <input type="radio" name="pet.petSex" value="母" title="母">
                        </div>
                    </c:if>
                    <c:if test="${pet.petSex==''}">
                        <div class="layui-input-block">
                            <input type="radio" name="pet.petSex" value="公" title="公" checked="">
                            <input type="radio" name="pet.petSex" value="母" title="母">
                        </div>
                    </c:if>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物年龄：</label>
                    <div class="layui-input-block">
                        <input type="text" name="pet.petAge" required lay-verify="required" placeholder="请输入宠物年龄"
                               autocomplete="off" class="layui-input " value=${pet.petAge}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物体重：</label>
                    <div class="layui-input-block">
                        <input type="text" name="pet.petWeight" required lay-verify="required"
                               placeholder="请输入体重" autocomplete="off" class="layui-input" value=${pet.petWeight}>
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