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

<script language="javascript" type="text/javascript"
	src="../js/DatePicker/WdatePicker.js"></script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="title-bar">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="26" class="title-bar-title-icon">&nbsp;</td>
						<td width="745" class="title-bar-text">会员管理--添加会员</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>
			<td align="center" width=20%>添加会员</td>
			<td align="left" width=80% style="color:red"></td>
		</tr>
	</table>
	<form action="update_User" method="post" enctype="multipart/form-data">
		<table width="66%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_border_cell_bg">
				<td class="table-cell">会员级别</td>
				<td class="table-cell" style="padding:3px" align="left">
					<label for="DC">钻卡</label>
					<input name="lytHuiyuan.hyLevel" id="DC" type="radio"
						value="钻卡">
					<label for="GC">金卡</label>
					<input name="lytHuiyuan.hyLevel" id="GC" type="radio"
						value="金卡">
					<label for="SC">银卡</label>
					<input name="lytHuiyuan.hyLevel" id="SC" type="radio"
						value="银卡">
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">
					会员姓名
				</td>
				<td class="table-cell" style="padding:3px" align="left">
				<input type="text" name="lytHuiyuan.hyname" id="hyname">
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">电话</td>
				<td class="table-cell" style="padding:3px" align="left">
					<input type="text" name="lytHuiyuan.phoneNumber" id="phoneNumber">
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">日期</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					class="Wdate" type="text" name="lytHuiyuan.applyTime"
					onClick="WdatePicker()" readonly="readonly"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">身份证号</td>
				<td class="table-cell" style="padding:3px" align="left">
					<input type="text" name="lytHuiyuan.identifyId" id="identifyId">
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">推荐人卡号</td>
				<td class="table-cell" style="padding:3px" align="left">
					<input type="text" name="lytHuiyuan.tjrId" id='tjrId'>
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
