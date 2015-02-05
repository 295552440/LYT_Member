<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table>
    <form action="" methdo="post">
    
    </form>
    
    </table>
    <table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			<tr>
				<td width="25%"><span class="oper-bar-text"> 按查询全部：</span><span
					class="title_bar"><select name="blog_order_list"
						class="form_select" onChange="queryByOrder(this.value)">
							<option value="" selected>排列顺序</option>
							<option value="date_desc">注册时间-降序</option>
							<option value="date">注册时间-升序</option>
							<option value="id_desc">用户ID-降序</option>
							<option value="id">用户ID-升序</option>
					</select> </span></td>
				<td width="20%" align="left"><span class="oper-bar-text">按是否开通博客查询：</span><span
					class="title_bar"> <select name="state" id="state"
						class="form_select" onChange="queryByState(this.value);">
							<option value="all">全部</option>
							<option value="state_no">已开通</option>
							<option value="state_yes">未开通</option>
					</select>
				</span></td>
				<td width="35%" align="right"><span class="oper-bar-text">搜索查询：
						<select name="search_list" id="search_list">
							<option value="userId">ID</option>
							<option value="userName">名称</option>

					</select> <input name="key" type="text" id="key" size="21" onKeyDown="">
						<input name="Submit5" type="button" class="form-buttun"
						onClick="return queryBySearch()" value="搜索">
				</span></td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			<tr>

				<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
						src="../images/admin/oper/msg.png" alt="消息" width='20' height='20'
						border="0"></img>
				</span>
				</td>
				<td width="20%" align="center">&nbsp;<span style="color:red">您好，共查询出
						<s:property value="page.totalRows" /> 条记录！
				</span>
				</td>
				<td width="20%" align="right">&nbsp;<span style="color:red"
					id="msgkey"></span>
				</td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_title">
				<td width="9%" class="table-titlebar">用户ID</td>
				<td width="9%" class="table-titlebar">博客ID</td>
				<td width="9%" class="table-titlebar">用户名</td>
				<td width="9%" class="table-titlebar">真实姓名</td>
				<td width="9%" class="table-titlebar">头像</td>
				<td width="9%" class="table-titlebar">注册时间</td>
				<td width="9%" class="table-titlebar">操作</td>
			</tr>
			<c:forEach items="${users }" var="item">
				<tr class="table_border_cell_bg">
					<td class="table-cell">${item.userId }</td>
					<td class="table-cell"><c:if
							test="${fn:length(item.blogs)!=0 }">
							<c:forEach var="entry" items="${item.blogs }">
								<c:out value="${entry.blogName}" />
							</c:forEach>
						</c:if> <c:if test="${fn:length(item.blogs)==0 }">未开通博客</c:if></td>
					<td class="table-cell">${item.userName }</td>
					<td class="table-cell">${item.userRealName }</td>
					<td class="table-cell"><img src="../${item.userHeadUrl }"
						width="50" height="50"></td>
					<td class="table-cell">${item.userRegisterDatetime }</td>
					<td class="table-cell"><a
						href="deleteUser?user.userId=${item.userId }">删除</a> <a
						href="queryUserById?user.userId=${item.userId }" target="main">编辑</a>
						<c:if test="${fn:length(item.blogs)==0 }">
							<a href="openBlog.jsp?userId=${item.userId }" target="main">开通博客</a>
						</c:if> <c:if test="${fn:length(item.blogs)!=0 }">
							<a href="../${item.userHeadUrl }" target=_blank>访问博客</a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
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
					&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td class="paeg_bar"></td>
			</tr>
		</table>
  </body>
</html>
