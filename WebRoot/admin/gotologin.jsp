<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link href="<%=request.getContextPath()%>/css/admin/oper_area.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="title-bar"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="26" class="title-bar-title-icon">&nbsp;</td>
        <td width="745" class="title-bar-text">欢迎您</td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" class="table-frame-input">
  <tr>
    <td height="100" colspan="2" class="table-frame-input-title">


<h2>由于您长时间没有操作，请重新登录！<a href="<%=request.getContextPath()%>/admin/login.jsp" target="_parent" style="color:red;font-size:20px">登录》》</a>
  
</h2>

</td>
  </tr>
   <%--  <tr>
    <td height="100" colspan="2" class="table-frame-input-title"><h1>由于您长时间没有操作，请重新登录！<a href="<%=request.getContextPath()%>/admin/login.jsp" target="_parent">登录》》</a>
  
</h1></td>
  </tr> --%>
</table>
  </body>
</html>
