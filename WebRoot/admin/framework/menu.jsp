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

<title>My JSP 'MyJsp.jsp' starting page</title>




<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<style type="text/css">
BODY {
	BACKGROUND: 799ae1;
	FONT-SIZE: 9pt;
}

.sec_menu {
	BORDER-RIGHT: white 1px solid;
	BACKGROUND: #d6dff7;
	OVERFLOW: hidden;
	BORDER-LEFT: white 1px solid;
	BORDER-BOTTOM: white 1px solid
}

.menu_title SPAN {
	FONT-WEIGHT: bold;
	LEFT: 10px;
	COLOR: #215dc6;
	POSITION: relative;
	TOP: 2px
}

.menu_title2 SPAN {
	FONT-WEIGHT: bold;
	LEFT: 10px;
	COLOR: #428eff;
	POSITION: relative;
	TOP: 2px
}

TD {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 18px
}

a:link {
	color: #3366FF;
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: #FF6600;
}

a:hover {
	text-decoration: underline;
	color: #33CCFF;
}

a:active {
	text-decoration: none;
	color: #33CCFF;
}
</style>
</head>

<body>

	<script>
		//var he = document.body.clientHeight - 105
		//document.write("<div id=tt style=height:"+he+";overflow:hidden>");

		document.write("<div id=tt ;overflow:hidden>");
	</script>
	<table cellSpacing="0" cellPadding="0" width="158" align="center">
		<tr>
			<td class="menu_title" id="imgmenu2"
				onMouseOver="this.className='menu_title2';" style="CURSOR: hand"
				onclick="showsubmenu(2)" onMouseOut="this.className='menu_title';"
				background="images/admin/left/menudown.gif" height="25"><span>会员管理</span>
			</td>
		</tr>
		<tr>
			<td id="submenu2" style="DISPLAY: ">
				<div class="sec_menu" style="WIDTH: 158px">
					<table cellSpacing="3" cellPadding="0" width="130" align="center">
						<tr>
							<td><A href="<%=request.getContextPath()%>/admin/queryByOrder?order=date_desc"  target="main">显示所有会员</A>
							</td>
						</tr>
						<tr>
							<td><A href="<%=request.getContextPath()%>/admin/addMember.jsp"  target="main">手动添加会员</A>
							</td>
						</tr>

					</table>
				</div> <br></td>
		</tr>
	

		
		<tr>
			<td class="menu_title" id="imgmenu9"
				onMouseOver="this.className='menu_title2';" style="CURSOR: hand"
				onclick="showsubmenu(9)" onMouseOut="this.className='menu_title';"
				background="images/admin/left/menudown.gif" height="25"><span>申请审核</span>
			</td>
		</tr>
	<tr>
			<td id="submenu9" style="DISPLAY: ">
				<div class="sec_menu" style="WIDTH: 158px">
					<div align="center">
						<table cellSpacing="3" cellPadding="0" width="130">
							<tr>
								<td><A href="admin/queryByState?state=state_wait" target="main">待审核</A>
								</td>
							</tr>
							<!-- <tr>
								<td><A href="admin/queryByState?state=state_no" target="main">审核未通过</A>
								</td>
							</tr> -->
							<tr>
								<td><A href="admin/queryByState?state=state_yes" target="main">审核通过</A>
								</td>
							</tr>
						</table>
					</div>
				</div> <br></td>
		</tr>
		
			<tr>
			<td class="menu_title" id="imgmenu1"
				onMouseOver="this.className='menu_title2';" style="CURSOR: hand"
				onclick="showsubmenu(1)" onMouseOut="this.className='menu_title';"
				background="images/admin/left/menudown.gif" height="25"><span>返现管理</span>
			</td>
		</tr>
		<tr>
			<td id="submenu1" style="DISPLAY:">
				<div class="sec_menu" style="WIDTH: 158px">
					<div align="center">
						<table cellSpacing="3" cellPadding="0" width="130">
							<tr>
								<td><A href="admin/queryAllAblum" target="main">口碑传播奖</A></td>
							</tr>
							<tr>
								<td><A href="admin/queryAllPhoto_ByPage" target="main">月任务奖</A>
								</td>
							</tr>
						</table>
					</div>
				</div> <br>
			</td>
		</tr>
		
		
		<tr>
			<td class="menu_title" id="imgmenu8"
				onMouseOver="this.className='menu_title2';" style="CURSOR: hand"
				onclick="showsubmenu(8)" onMouseOut="this.className='menu_title';"
				background="images/admin/left/menudown.gif" height="25"><span>管理员设置</span>
			</td>
		</tr>
		<tr>
			<td id="submenu8" style="DISPLAY: ">
				<div class="sec_menu" style="WIDTH: 158px">
					<div align="center">
						<table cellSpacing="3" cellPadding="0" width="130">
							<tr>
								<td><A href="admin/adminManage.jsp" target="main">账号设置</A>
								</td>
							</tr>
							<tr>
								<td><A href="<%=request.getContextPath()%>/admin/logout" target="_parent">退出系统</A>
								</td>
							</tr>
						</table>
					</div>
				</div> <br></td>
		</tr>
	</table>




	<script>
		function showsubmenu(sid) {
			whichEl = eval("submenu" + sid);
			imgmenu = eval("imgmenu" + sid);
			if (whichEl.style.display == "none") {
				eval("submenu" + sid + ".style.display=\"\";");
				imgmenu.background = "images/admin/left/menuup.gif";
			} else {
				eval("submenu" + sid + ".style.display=\"none\";");
				imgmenu.background = "images/admin/left/menudown.gif";
			}
		}
	</script>
</body>
</html>
