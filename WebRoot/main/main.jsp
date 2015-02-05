<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>

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
	<form action="queryById?huiyuanid=06" method="post">
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
					</select> </span>
				</td>
				<td width="35%" align="right"><span class="oper-bar-text">搜索查询：
						<select name="search_list" id="search_list">
							<option value="id">ID</option>

					</select> <input name="huiyuanid" type="text" id="huiyuanid" size="21" onKeyDown="">
						<input name="Submit5" type="submit" class="form-buttun"
						 value="搜索"> </span>
				</td>
			</tr>
		</table>
	</form>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>

			<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
					src="../images/admin/oper/msg.png" alt="消息" width='20' height='20'
					border="0"></img> </span></td>
			<td width="20%" align="center">&nbsp;<span style="color: red">您好，共查询出
					<s:property value="page.totalRows" /> 条记录！ </span></td>
			<td width="20%" align="right">&nbsp;<span style="color: red"
				id="msgkey"></span></td>
		</tr>
	</table>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table-frame">
		<tr class="table_title">
			<td width="9%" class="table-titlebar">ID</td>
			<td width="9%" class="table-titlebar">推荐人编号</td>
			<td width="9%" class="table-titlebar">被推荐人卡号</td>
			<td width="9%" class="table-titlebar">推荐的时间</td>
			
			<td width="9%" class="table-titlebar">返利状态</td>
			<td width="9%" class="table-titlebar">返利金额</td>
			<td width="9%" class="table-titlebar">返利类型</td>
			<td width="9%" class="table-titlebar">返利时间</td>
		</tr>
		<c:forEach items="${setLytFanlis }" var="flset">
			<tr>
				<td class="table-cell"><c:out value="${flset.id}"/>${flset.id }</td>
				
				<td class="table-cell">${flset.lytHuiyuanByBtjrId }</td>
				<td class="table-cell">${flset.lytHuiyuanByTjrId }</td>
				<td class="table-cell">${flset.tjTime }</td>
				<td class="table-cell">${flset.fanliState }</td>
				<td class="table-cell">${flset.fanliMoney }</td>
				<td class="table-cell">${flset.fanliType }</td>
				<td class="table-cell">${flset.fanliTime }</td>
			</tr>
		</c:forEach>
	</table>
	
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="paeg_bar"></td>
		</tr>
	</table>
</body>
</html>
