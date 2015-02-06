<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'listUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=request.getContextPath()%>/css/admin/oper_area.css"
	rel="stylesheet" type="text/css">
<script src="../js/jquery-1.8.2.js" type="text/javascript"></script>

<script language="javascript" type="text/javascript">
	
	
	function checkName() {
	var name = $("#adminName").val();
		if (name == "") {
			$("#newAdminNameMsg").html("×：姓名不能为空");
			return false;
		}
		if (name.length < 5) {
			$("#newAdminNameMsg").html("×：用户名至少为5个字符");
			return false;
		}
	$("#newAdminNameMsg").html("√");
		return true;
	}
	function checkOldPw() {

		var oldPw = $("#oldPw").val();
		var oldAdminName = $("#oldAdminName").val();
		
		
		if (oldPw == "") {
			$("#oldPwMsg").html("×：原始密码不能为空!");
			return false;
		}
		//alert(oldPw+oldAdminName)
		var url="admin/checkOldPw";
		var params = {
			"admin.adminPassword" : oldPw,
			"admin.adminName" :oldAdminName
			
			
		};
		$.ajax({
			url : url,
			type : "post",
			data : params,
			dataType : "json",

			success : function(data) {

				var msg = data.message;
				if (msg ==0) {
					msg = "√：密码正确！";
					$("#oldPwMsg").html(msg);
					
				} 
				if(msg ==1){
					msg = "×：密码不正确，请重新输入！";
					$("#oldPwMsg").html(msg);
					return false;
				}	

			},
			error : function() {

				alert("长时间未登录,请重新登录");
				//window.open("login.jsp");//打开新窗口
				//window.navigate("admin/login.jsp"); 
				//window.location.href="login.jsp"; 
				window.parent.location.href="login.jsp";
				return false;

			}
		});

		return true;
	}
	
	function checkPw() {
	var pw = $("#password").val();
		if (pw == "") {
			$("#pwdMsg").html("×：密码不能为空");
			return false;
		}
		if (pw.length < 6) {
			$("#pwdMsg").html("×：密码至少为6个字符");
			return false;
		}
		$("#pwdMsg").html("√");
		return true;
	}

	function checkPw2() {
	var pw = $("#password").val();
	var pw2 = $("#password2").val();
		if (pw2 != pw) {
			$("#pwdMsg2").html("×：密码输入不一致");
			return false;
		}
        $("#pwdMsg2").html("√");
		return true;
	}
	
	function doUpdate() {
	
		var name = $("#adminName").val();
		var pw = $("#password").val();
		var id = $("#adminId").val();

	if(checkPw()&&checkOldPw()&&checkPw2()){
	
	//alert(name+pw);
	var url="admin/adminModify";
		var params = {
			"admin.adminPassword" : pw,
			"admin.adminName" :name,
			"admin.id" :id
		};
		$.ajax({
			url : url,
			type : "post",
			data : params,
			dataType : "json",

			success : function(data) {

				var msg = data.message;

				alert(msg);
				window.location.href="<%=request.getContextPath()%>/admin/adminManage.jsp";  
				
				
				
				
			},
			error : function() {

				alert("请求失败");
				return false;

			}
		});
	
	
			
		}else{
	
			return;
		}

	}
	
</script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="title-bar">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="26" class="title-bar-title-icon">&nbsp;</td>
						<td width="745" class="title-bar-text">管理员设置--账号设置</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>
			<td align="center" width=20%>账号设置</td>
			<td align="left" width=80% style="color:red"></td>
		</tr>
	</table>
	<form  method="post" enctype="multipart/form-data">
		<table width="66%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_border_cell_bg">
				<td class="table-cell">账号名称：</td>
				<td class="table-cell" style="padding:3px" align="left">
					<input id="oldAdminName" type="hidden"
						value="${sessionScope.admin.adminName }">
					<input id="adminId" type="hidden"
						value="${sessionScope.admin.id }">
					<input name="admin.adminName" id="adminName" type="text"
						value="${sessionScope.admin.adminName }" onBlur="checkName()">
						
						<span><font size="3" color="red" id="newAdminNameMsg">您可以在此处修改管理员账号名称</font></span>
					
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">
					原始密码：
				</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input type="password" name="oldPw" id="oldPw"
				onBlur="checkOldPw()">
					<span><font size="3" color="red" id="oldPwMsg">请输入原始密码</font></span>
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">
					新密码：
				</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input type="password" name="admin.adminPassword" id="password"
				onBlur="checkPw()">
					<span><font size="3" color="red" id="pwdMsg">请输入新密码</font></span>
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">
					再次输入：
				</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input type="password"  id="password2" onBlur="checkPw2()"
				>
					<span><font size="3" color="red" id="pwdMsg2">请再次输入新密码</font></span>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td style="padding:3px" align="right"><input type="button"
					value="确定" onclick="doUpdate()"></td>
				<td style="padding:3px" align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset" value="取消"></td>
			</tr>
		</table>
		<font size="3" color="red">${message }</font>
	</form>
</body>
</html>
