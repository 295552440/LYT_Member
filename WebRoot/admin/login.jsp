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
<base href="<%=basePath%>">
<title>丽颜堂会员管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	background-image: url(images/admin/login/bj.jpg);
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
	font-family: "宋体";
	line-height: 22px;
}

.tab {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #1A3D7D;
}

.form_input {
	font-size: 12px;
	color: #000000;
	background-color: #FFFFFF;
	border: 1px solid #003366;
}
-->
</style>
<script>
	function login() {
		var userName = document.getElementById("userName");
		var password = document.getElementById("password").value;
		if (userName.value == "" || password == "") {
			document.getElementById("mes").style.display = "block";
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body>
	<form id="login-form" action="admin/adminLogin" method="post">

		<table width="99%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center"><table width="597" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="205"><img src="images/admin/login/lo_03.gif"
								width="205" height="103">
							</td>
							<td><img src="images/admin/login/lo_04.gif" width="392"
								height="103">
							</td>
						</tr>
						<tr>
							<td><img src="images/admin/login/lo_06.gif" width="205"
								height="211">
							</td>
							<td valign="top" background="images/admin/login/lo_07.gif"><table
									width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="100%" valign="top"><table width="100%"
												border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td height="37">&nbsp;</td>
												</tr>
												<tr>
													<td><table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td width="18%">&nbsp;</td>
																<td width="82%"><table width="80%" border="0"
																		cellpadding="5" cellspacing="0">
																		<tr>
																			<td width="24%"><span class="STYLE1">用户名：</span>
																			</td>
																			<td colspan="2"><input id="userName"
																				name="admin.adminName" type="text"
																				class="form_input" size="20" style="width:80%">
																			</td>
																		</tr>
																		<tr>
																			<td class="STYLE1">密 码：</td>
																			<td colspan="2"><input id="password"
																				name="admin.adminPassword" type="password"
																				class="form_input" style="width:80%"></td>
																		</tr>

																		<tr>
																			<td colspan="2" class="STYLE1"><input
																				type="submit" name="commit" value="Login" />
																			</td>
																			<td><font color="red">${message }</font>
																			</td>
																		</tr>

																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td width="0%" align="right"><img
											src="images/admin/login/lo_072.gif" width="1" height="211">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2"><img src="images/admin/login/lo.gif"
								width="597" height="36">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>