<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>返利管理--月任务奖</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../js/jquery-1.8.2.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/admin/oper_area.css"
	rel="stylesheet" type="text/css">
</head>

<script type="text/javascript">
		//order查询	
	function queryByOrder(order) {
		location.href = "queryMonthByOrder?order=" + order;

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
						<td class="title-bar-title-icon">&nbsp;</td>
						<td class="title-bar-text">返利管理--月任务奖</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form action="" method="post">
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			
			
			
			
			<tr>
					<td width="25%"><span class="oper-bar-text"> 按顺序查询全部：</span><span
					class="title_bar"><select name="blog_order_list"
						class="form_select" onChange="queryByOrder(this.value)">
							<option value="" selected>排列顺序</option>
							<option value="date_desc">月份-降序</option>
							<option value="date">月份-升序</option>
							<!-- <option value="id_desc">会员卡号-降序</option>
							<option value="id">会员卡号-升序</option> -->
					</select> </span></td>
			
				<td width="20%" align="left"><span class="oper-bar-text">按返利状态：</span><span
					class="title_bar"> <select name="state" id="state"
						class="form_select" onChange="queryByState(this.value);">
							<option value="all">全部</option>
							<option value="state_yes">已返利</option>
							<option value="state_wait">未返利</option>
							<!-- <option value="state_no">审核未通过</option> -->
					</select> </span></td>
			
			
				<td width="35%" align="right"><span class="oper-bar-text">搜索查询： <select
						name="search_list" id="search_list">
							<option value="id">会员卡号</option>
					</select> <input name="hycardId" type="text" id="hycardId" size="21" /> </span>
				<input name="Submit5" type="button" class="form-buttun"
					onclick="return queryByTypeHy(1)" value="搜索" />
				</td>
			</tr>
		</table>
	</form>

	
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>

			<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
					src="../images/admin/oper/msg.png" alt="消息" width='20' height='20' border="0"></img> </span></td>

			<td width="20%" align="center">&nbsp;<span style="color: red"
				id="msgkey" name="msgkey"></span> <c:if test="${empty lytHuiyuan}">
					<span style="color: red">没有这个卡号的会员！</span>
				</c:if> <c:if test="${empty lytFanlis}">
					<span style="color: red">没有返利记录!</span>
				</c:if></td>
		</tr>
	</table>

	<c:if test="${ not empty lytHuiyuan }">
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_title">
				
				<td class="table-titlebar">会员卡号</td>
				<td class="table-titlebar">姓名</td>
				<td class="table-titlebar">完成月份</td>
				<td class="table-titlebar">推荐人数</td>
				<td class="table-titlebar">返现金额</td>
				<td class="table-titlebar">返现状态</td>
				<td class="table-titlebar">操作</td>
				


			</tr>

			<tr>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
				<td class="table-cell"></td>
			</tr>

		</table>
	</c:if>
	
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="paeg_bar"><a> 第${currentPage} 页/
					共${pageliu.totalPages } 页(共 ${pageliu.totalRows } 条) </a> [<span
				class="list_text"><a href="javascript:queryByTypeHy(1)">首页</a>
			</span>] <c:if test="${currentPage== 1 }">
					[<span class="list_text"> <a>已是首页</a> </span>] 
			</c:if> <c:if test="${currentPage> 1 }">
					[<span class="list_text"> <a
						href="javascript:queryByTypeHy(${currentPage-1 })">上一页</a> </span>] 
			</c:if> <c:if test="${currentPage==pageliu.totalPages }">
				[<span class="list_text"> <a>已是末页</a> </span>]
			</c:if> <c:if test="${currentPage<pageliu.totalPages}">
				[<span class="list_text"> <a
						href="javascript:queryByTypeHy(${currentPage+1 })">下一页</a> </span>]
				</c:if> [<span class="list_text"><a
					href="javascript:queryByTypeHy(${pageliu.totalPages })">末页</a> </span>]
				&nbsp;&nbsp;</td>
		</tr>
	</table>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="page_bar"></td>
		</tr>
	</table>
</body>
</html>
