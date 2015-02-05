<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//将首页跳转到登录页面
response.sendRedirect(basePath+"admin/framework/main.jsp");  
%>