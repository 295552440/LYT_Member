<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link href="../../css/admin/style.css" rel="stylesheet" type="text/css">

<link href="../../css/admin/left_ctrl_bar.css" rel="stylesheet"
	type="text/css">
<script>
	var show = true;

	function menuShowOrHide(){
		
	
		if(show){
			show = false;
			document.all.buttonTable.className = "exp_button";
		}else{
			show = true;
			document.all.buttonTable.className = "col_button";
		}
		
		top.showOrHiddenLogoFrame(show);

	}
</script>
</head>

<body>
<table width="10" height="100%" border="0" cellpadding="0" cellspacing="0" style="cursor:pointer" onClick="menuShowOrHide()">
  <tr>
    <td class="ctrl-bar-up">&nbsp;</td>
  </tr>
  <tr>
    <td class="ctrl-bar-bg">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="col_button" id="buttonTable">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="crtl-bar-down">&nbsp;</td>
  </tr>
</table>
</body>
</html>
