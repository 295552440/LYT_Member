<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%--   <base href="<%=basePath%>"> --%>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="../../css/admin/style.css" rel="stylesheet" type="text/css">

<link href="../../css/admin/top.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="logo-bg">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr >
        <td class="logo" style="cursor:pointer"><a href="<%=request.getContextPath()%>/admin/framework/main.jsp" target="_self"></a></td>
        <td align="right" class="login-text"></td>
        <td width="280" align="center"><table border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="right-button-left">&nbsp;</td>
            <td align="right" class="right-button-bg"><table border="0" cellspacing="0" cellpadding="0">
              <tr>
			 
              <!--   <td class="button-help-mouseout" onMouseOut="this.className='button-help-mouseout'" onMouseOver="this.className='button-help-mouseover'" style="cursor:pointer" onClick="top.mainFrame.location.href='http://www.blog4j.com'">&nbsp;</td>
                <td class="button-split-line">&nbsp;</td> -->
				<td class="button-mpwd-mouseout" onMouseOut="this.className='button-mpwd-mouseout'" onMouseOver="this.className='button-mpwd-mouseover'" style="cursor:pointer" onClick="top.mainFrame.location.href='../modify_pwd.jsp'">&nbsp;</td>
                <td class="button-split-line">&nbsp;</td>
                <td class="button-logout-mouseout" onMouseOut="this.className='button-logout-mouseout'" onMouseOver="this.className='button-logout-mouseover'" style="cursor:pointer" onClick="top.location.href='../../AdminLogout'">&nbsp;</td>
                </tr>
            </table></td>
            <td class="right-button-right">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="3" class="bottom-line"></td>
  </tr>
</table>
  </body>
</html>
