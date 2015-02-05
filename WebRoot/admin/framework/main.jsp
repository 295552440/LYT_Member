<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>丽颜堂会员管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<script>

//控制LOGO框架的显示与隐藏
function showOrHiddenLogoFrame(isShow){
	if (isShow){
		document.all.middleFrame.cols = "180,10,*";
	}else{
		document.all.middleFrame.cols = "0,10,*";
	}
}
</script> 
 
 
 
 
 
  
 <frameset rows="33,30,*,4" cols="*" frameborder="yes" border="0" framespacing="0" id="fwFrame"> 
  <frame name="logoFrame" scrolling="NO" noresize src="<%=request.getContextPath()%>/admin/framework/top.jsp" frameborder="0">
  <frame name="menutabFrame" scrolling="NO" noresize src="<%=request.getContextPath()%>/admin/framework/menu_tab.jsp" frameborder="0">

  	<frameset rows="*" cols="180,10,*" frameborder="NO" border="0" framespacing="0" id="middleFrame"> 
    	<frame name="menuFrame" noresize scrolling="auto" src="<%=request.getContextPath()%>/admin/framework/menu.jsp" frameborder="0">
    	<frame name="leftCtruBarFrame" src="<%=request.getContextPath()%>/admin/framework/left_ctrl_bar.jsp" noresize scrolling="NO">
    	<frame name="main" src="<%=request.getContextPath()%>/admin/framework/welcome.jsp" noresize scrolling="yes">
  	</frameset>

  <frame name="stateBarFrame" scrolling="NO" noresize src="<%=request.getContextPath()%>/admin/framework/state_bar.jsp" frameborder="0">
</frameset>


<noframes> 
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">




</body>
</noframes> 
</html>
