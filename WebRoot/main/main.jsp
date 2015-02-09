<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>返利查询</title>
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
	//卡号和类型查询；
	function queryByTypeHy(currentPage) {
		var hycardId = $("#hycardId").val();
		var fanliType = $("#fanliType").val();
		var fanliState = $("#fanliState").val();
		//alert(hycardId);
		//alert(fanliType);
		//alert(fanliState);
		if (hycardId == "") {
			alert("id不能为空");
			$("#msgkey").innerHTML = "输入不能为空！";
			return false;
		} else {
			window.location.href = "queryByTypeHy?hycardId=" + hycardId
					+ "&fanliType=" + fanliType +"&fanliState=" +fanliState
					+ "&currentPage="+currentPage;
			return true;
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
						<td class="title-bar-title-icon">&nbsp;</td>
						<td class="title-bar-text">用户返利查询</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form action="" method="post">
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			<tr>
				<td align="right"><span class="oper-bar-text">搜索查询： <select
						name="search_list" id="search_list">
							<option value="id">会员卡号</option>
					</select> <input name="hycardId" type="text" id="hycardId" size="21" /> </span>
				</td>
				<td><span class="oper-bar-text"> 类型：</span><span
					class="title_bar"><select name="fanliType" id="fanliType"
						class="form_select">
							<option value="" selected>返利的类型</option>
							<option value="0">口碑传播奖</option>
							<option value="1">月任务奖</option>
					</select> </span>
				</td>
				<td><span class="oper-bar-text"> 状态：</span><span
					class="title_bar"><select name="fanliState" id="fanliState"
						class="form_select">
							<option value="" selected>返利的状态</option>
							<option value="0">未返利</option>
							<option value="1">返利</option>
					</select> </span>
				</td>
				<td><input name="Submit5" type="button" class="form-buttun"
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
				<td class="table-titlebar">ID</td>
				<td class="table-titlebar">会员姓名</td>
				<td class="table-titlebar">卡号</td>
				<td class="table-titlebar">级别</td>
				<td class="table-titlebar">申请时间</td>


			</tr>

			<tr>
				<td class="table-cell">${lytHuiyuan.id}</td>
				<td class="table-cell">${lytHuiyuan.hyname}</td>
				<td class="table-cell">${lytHuiyuan.hycardId }</td>
				<td class="table-cell">${lytHuiyuan.hyLevel}</td>
				<td class="table-cell">${lytHuiyuan.applyTime}</td>
			</tr>

		</table>
	</c:if>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table-frame">
		<tr class="table_title">
			<td class="table-titlebar">ID</td>
			<td class="table-titlebar">推荐人编号</td>
			<td class="table-titlebar">被推荐人卡号</td>
			<td class="table-titlebar">推荐的时间</td>

			<td class="table-titlebar">返利状态</td>
			<td class="table-titlebar">返利金额</td>
			<td class="table-titlebar">返利类型</td>
			<td class="table-titlebar">返利时间</td>
		</tr>
		<c:forEach items="${lytFanlis}" var="flset" varStatus="st">
			<tr>
				<td class="table-cell">${flset.id}</td>
				<td class="table-cell">${flset.lytHuiyuanByTjrId.hycardId }</td>
				<td class="table-cell">${flset.lytHuiyuanByBtjrId.hycardId }</td>
				<td class="table-cell">${flset.tjTime }</td>
				<c:if test="${flset.fanliState == 0}">
					<td class="table-cell">未返利</td>
				</c:if>
				<c:if test="${flset.fanliState == 1}">
					<td class="table-cell">返利</td>
				</c:if>
				<td class="table-cell">${flset.fanliMoney }</td>
				<c:if test="${flset.fanliType == 0}">
					<td class="table-cell">口碑传播奖</td>
				</c:if>
				<c:if test="${flset.fanliType == 1}">
					<td class="table-cell">月任务奖</td>
				</c:if>
				<td class="table-cell">${flset.fanliTime }</td>
				<td class="table-cell">${flset.fanliTime }</td>
			</tr>
			<c:if test="${st.last}">
				<tr>
					<td width="20%" align="center">&nbsp;<span style="color: red">共查询出
							${st.count }条记录！ </span></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
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
