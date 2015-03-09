<%@page import="com.lyt.member.entity.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	/* Admin admin = (Admin) session.getAttribute("admin");
	if (admin == null) {
		response.sendRedirect(basePath + "admin/gotologin.jsp");
	} */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>返利管理--优秀个人奖</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../js/jquery-1.8.2.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/admin/oper_area.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/main/web/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700'
	rel='stylesheet' type='text/css'>
<style type="text/css">
.table_title{
margin: 0px 0px 0px 0px;
padding: 0px 0px 0px 0px;
border: 0px none;

}
.header{
margin: 0px 0px 0px 0px;
height:75px;
}
.cssmenu li a {
text-decoration:none;
}
</style>
</head>

<script type="text/javascript">
	//order查询	
	/* function queryByOrder(order) {
		location.href = "queryMonthByOrder?order=" + order;

	} */
	//queryByState
	/* function queryByState(state) {
		location.href = "queryMonthByState?state=" + state;
	} */

	//搜索查询	
	function queryBySearch() {

		var searchInput = $("#key").val();
		if (searchInput == "") {
			//alert("id不能为空");
			$("#msgkey").html("输入不能为空！");
			return false;
		}

		var searchBy = $("#search_list").val();
		/* if (searchBy == "id" & isNaN(searchInput)) {
			//alert("id不能为空");
			$("msgkey").innerHTML = "Id输入必须为数字！";
			return false;
		} */

		location.href = "queryMonthBySearch?searchBy=" + searchBy
				+ "&searchInput=" + searchInput;
		return true;
	}

	//页面跳转	
	function refreshPage() {

		var currentPage = $("#refreshCurrentPage").val();
		if (currentPage == "") {
			alert("输入不能为空！");
			//$("msgkey").innerHTML = "输入不能为空！";
			return false;
		}
		if (isNaN(currentPage)) {
			alert("输入必须为数字！");
			//$("msgkey").innerHTML = "Id输入必须为数字！";
			return false;
		}

		location.href = "<s:property value="queryMethod"/>?pageMethod=refresh&currentPage="
				+ currentPage;

		return true;
	}
</script>
</head>
<body>

	<div class="header">
		<div class="header-top">
			<div class="wrap">
				<div class="logo">
					<a href="<%=request.getContextPath()%>/index.jsp"><img src="<%=request.getContextPath()%>/main/web/images/logo.png" alt="" />
					</a>
				</div>
				<div class="cssmenu">
					<ul id="nav">
						<!-- <li class="current"> --><li><a href="<%=request.getContextPath()%>/main/web/index.jsp">首页</a>
						</li>
						<!-- <li class="current"> --><li><a
							href="<%=request.getContextPath()%>/main/add.jsp">会员申请</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/main/web/index.jsp#section-2" >会员制分销模式介绍</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/main/main.jsp" >返利查询--口碑传播奖</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/main/month.jsp" >返利查询--优秀个人奖</a>
						</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
			

	</div>



	<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_title">
		<tr>
			<td class="title-bar">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="title-bar-title-icon">&nbsp;</td>
						<td class="title-bar-text">返利管理--月任务奖</td>
					</tr>
				</table></td>
		</tr>
	</table> -->
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>
			<td align="center" width=20%>返利查询--优秀个人奖</td>
			<td align="left" width=80% style="color:red"></td>
		</tr>
	</table>

	<form action="" method="post">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">




			<tr>
				<%-- <td width="25%"><span class="oper-bar-text"> 按顺序查询全部：</span><span
					class="title_bar"><select name="blog_order_list"
						class="form_select" onChange="queryByOrder(this.value)">
							<option value="" selected>排列顺序</option>
							<option value="date_desc">月份-降序</option>
							<option value="date">月份-升序</option>
							<!-- <option value="id_desc">会员卡号-降序</option>
							<option value="id">会员卡号-升序</option> -->
					</select> </span>
				</td> --%>

			<%-- 	<td width="20%" align="left"><span class="oper-bar-text">按返利状态：</span><span
					class="title_bar"> <select name="state" id="state"
						class="form_select" onChange="queryByState(this.value);">
							<option value="all">全部</option>
							<option value="state_yes">已返利</option>
							<option value="state_wait">未返利</option>
							<!-- <option value="state_no">审核未通过</option> -->
					</select> </span>
				</td> --%>



				<td width="50%" align="center"><span class="oper-bar-text">搜索查询：
						<select name="search_list" id="search_list">
							<option value="id">会员卡号</option>
							<!-- <option value="name">会员姓名</option>
 -->
					</select> <input name="key" type="text" id="key" size="21" onKeyDown="">
						<input name="Submit5" type="button" class="form-buttun"
						onClick="return queryBySearch()" value="搜索"> </span>
				</td>
			</tr>
		</table>
	</form>


	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>

			<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
					src="../images/admin/oper/msg.png" alt="消息" width='20' height='20'
					border="0"></img> </span></td>
			<td width="20%" align="center">&nbsp;<span style="color:red">您好，共查询出
					<s:property value="page.totalRows" /> 条记录！ </span></td>
			<td width="20%" align="right">&nbsp;<span style="color:red"
				id="msgkey"></span></td>
		</tr>
	</table>


	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table-frame">
		<tr class="table_title">

			<td class="table-titlebar">会员卡号</td>
			<td class="table-titlebar">姓名</td>
			<td class="table-titlebar">完成月份</td>
			<td class="table-titlebar">推荐人数</td>
			<td class="table-titlebar">返现金额</td>
			<td class="table-titlebar">返现状态</td>
			<!-- <td class="table-titlebar">操作</td> -->



		</tr>
		<s:iterator id="list" value="list" var="blogList" status="status">
			<tr>
				<td class="table-cell"><s:property value="tjrCardId" />
				</td>
				<td class="table-cell"><s:property value="tjrName" />
				</td>
				<td class="table-cell"> 
				<s:date name="tjTime" format="yyyy-MM"/>
				
				
				</td>
				<td class="table-cell"><s:property value="tjRenshu" />
				</td>
				<td class="table-cell"><s:property value="fanLimoney" />
				</td>
				<td class="table-cell"><s:if test="fanliState==0">
						<span style="color:red">未返利</span>
					</s:if> <s:if test="fanliState==1">已返利</s:if></td>
				<%-- <td class="table-cell"><s:url id="url2"
						action="updateMonthState">
						<s:param name="lytMonth.id" value="id" />
					</s:url> <s:if test="fanliState==0">
						<a
							href="javascript:if(confirm('确认标注该条记录为“已返利”吗，注意标注后不可更改请慎重！'))location='<s:property value="#url2"/>'">标注为“已返利”</a>
						<a href="<s:property value="#url2"/>">审核</a>
					</s:if> <s:if test="fanliState==1">不可操作</s:if></td> --%>
			</tr>
		</s:iterator>
	</table>

	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>

			<td class="paeg_bar">
				<!-------------------------
					---------------------下面代码达到如此效果：1 / 4 页(共 19 条) --> <s:property
					value="page.currentPage" /> / <s:property value="page.totalPages" />
				页(共 <s:property value="page.totalRows" /> 条) &nbsp;&nbsp;&nbsp;跳转至<input
				type="text" name="refreshCurrentPage" id="refreshCurrentPage"
				size="3" />页

				<button type="button" class="form-buttun"
					onClick="return refreshPage()">GO</button>&nbsp;&nbsp;[<span
				class="list_text"><a
					href="<s:property value="queryMethod"/>?pageMethod=first">首页</a> </span>]
				[<span class="list_text"><a
					href="<s:property value="queryMethod"/>?pageMethod=previous">上一页</a>
			</span>] [<span class="list_text"><a
					href="<s:property value="queryMethod"/>?pageMethod=next">下一页</a> </span>]
				[<span class="list_text"><a
					href="<s:property value="queryMethod"/>?pageMethod=last">末页</a> </span>]
				&nbsp;&nbsp;</td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="page_bar"></td>
		</tr>
	</table>
</body>
</html>
