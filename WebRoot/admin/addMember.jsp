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
<script src="../js/jquery.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="title-bar">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="26" class="title-bar-title-icon">&nbsp;</td>
						<td width="745" class="title-bar-text">用户管理--编辑用户</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>
			<td align="center" width=20%>编辑用户</td>
			<td align="left" width=80% style="color:red"></td>
		</tr>
	</table>
	<form action="update_User" method="post" enctype="multipart/form-data">
		<table width="66%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_border_cell_bg">
				<td class="table-cell">用户ID</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userId value="${user.userId }"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">用户名</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userName id="userName"
					value="${user.userName }" readonly="readonly"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">密码</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userPassword id="userPassword"
					value="${user.userPassword}"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">真实姓名</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userRealName id="userRealName"
					value="${user.userRealName }"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">上传头像</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input type="hidden" name=user.userHeadUrl value="${user.userHeadUrl }"> 
				<input type="file" name=upload id="upload"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">性别</td>
				<td class="table-cell" style="padding:3px" align="left">
				<c:if test="${user.userSex == '男'}">
					<input type="radio" name="user.userSex" value='男' checked="checked">男
					<input type="radio" name="user.userSex" value='女'>女
				</c:if>
				<c:if test="${user.userSex == '女'}">
					<input type="radio" name="user.userSex" value='男'>男
					<input type="radio" name="user.userSex" value='女' checked="checked">女
				</c:if>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">生日</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input class="Wdate" type="text" name=user.userBirthday onClick="WdatePicker()" readonly="readonly">
				</td>

			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">userAgency</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userAgency id="userAgency"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">userPost</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userPost id="userPost"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">邮箱</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userEmail id="userEmail"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">电话</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userPhone id="userPhone"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">userDegree</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userDegree id="userDegree"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">userSelfIntroduce</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name=user.userSelfIntroduce id="userSelfIntroduce">
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>

			</tr>
			<tr>
				<td style="padding:3px" align="right"><input type="submit"
					value="确定"></td>
				<td style="padding:3px" align="left">&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset" value="取消"></td>
			</tr>
		</table>
		<font size="3" color="red">${message }</font>
	</form>
</body>
</html>
