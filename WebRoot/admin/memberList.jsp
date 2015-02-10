<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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

<script type="text/javascript">
	/* function $(id) {
		return document.getElementById(id);
	} */

	//多条件查询	
	/* 	function queryByMultiCondition(input) {
	 location.href = "queryByMultiCondition?input=" + input;

	 } */
	//order查询	
	function queryByOrder(order) {
		location.href = "queryByOrder?order=" + order;

	}
	//queryByState
	function queryByState(state) {
		location.href = "queryByState?state=" + state;
	}

	//搜索查询	
	function queryBySearch() {

		var searchInput = $("#key").val();
		if (searchInput == "") {
			//alert("id不能为空");
			$("#msgkey").html("输入不能为空！");
			return false;
		}

		var searchBy =$("#search_list").val();
		/* if (searchBy == "id" & isNaN(searchInput)) {
			//alert("id不能为空");
			$("msgkey").innerHTML = "Id输入必须为数字！";
			return false;
		} */

		location.href = "queryBySearch?searchBy=" + searchBy + "&searchInput="
				+ searchInput;
		return true;
	}

	//页面跳转	
	function refreshPage() {

		var currentPage =$("#refreshCurrentPage").val();
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
<script type="text/javascript">
	function display(id) {
		//alert("#"+""+id+"");
		$("#"+""+id+"").show();
	
		//document.getElementById(id).style.display = "block";
	}
	function disappear(id) {
	     $("#"+""+id+"").hide();
		//document.getElementById(id).style.display = "none";
	}
</script>



</head>

<body>

	
	<form action="" method="post" name="">
		<table id="55" width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="title-bar">
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="26" class="title-bar-title-icon">&nbsp;</td>
							<td width="745" class="title-bar-text">会员管理</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			<tr>
				<td width="25%"><span class="oper-bar-text"> 按顺序查询全部：</span><span
					class="title_bar"><select name="blog_order_list"
						class="form_select" onChange="queryByOrder(this.value)">
							<option value="" selected>排列顺序</option>
							<option value="date_desc">申请时间-降序</option>
							<option value="date">申请时间-升序</option>
							<option value="id_desc">会员卡号-降序</option>
							<option value="id">会员卡号-升序</option>
					</select> </span></td>
				<td width="20%" align="left"><span class="oper-bar-text">按是否审核通过：</span><span
					class="title_bar"> <select name="state" id="state"
						class="form_select" onChange="queryByState(this.value);">
							<option value="all">全部</option>
							<option value="state_yes">审核通过</option>
							<option value="state_wait">待审核</option>
							<!-- <option value="state_no">审核未通过</option> -->
					</select> </span></td>
				<td width="35%" align="right"><span class="oper-bar-text">搜索查询：
						<select name="search_list" id="search_list">
							<option value="id">会员卡号</option>
							<option value="name">会员姓名</option>

					</select> <input name="key" type="text" id="key" size="21" onKeyDown="">
						<input name="Submit5" type="button" class="form-buttun"
						onClick="return queryBySearch()" value="搜索"> </span></td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="oper-bar">
			<tr>

				<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
						src="../images/admin/oper/msg.png" alt="消息" width='20' height='20'
						border="0"></img> </span>
				</td>
				<td width="20%" align="center">&nbsp;<span style="color:red">您好，共查询出
						<s:property value="page.totalRows" /> 条记录！ </span>
				</td>
				<td width="20%" align="right">&nbsp;<span style="color:red"
					id="msgkey"></span>
				</td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_title">
				<!-- 	<td width="5%" class="table-titlebar">ID(隐藏)</td> -->
				<td width="6%" class="table-titlebar">会员卡号</td>
				<td width="5%" class="table-titlebar">会员姓名</td>
				<td width="3%" class="table-titlebar">级别</td>
				<td width="5%" class="table-titlebar">电话</td>
				<td width="5%" class="table-titlebar">身份证号</td>
				<td width="5%" class="table-titlebar">银行卡账号</td>
				<td width="4%" class="table-titlebar">收款人</td>
				<td width="5%" class="table-titlebar">收货地址</td>
				<td width="6%" class="table-titlebar">推荐人卡号</td>
				<td width="4%" class="table-titlebar">会员费</td>
				<td width="3%" class="table-titlebar">邮费</td>
				<td width="4%" class="table-titlebar">合计</td>
				<td width="5%" class="table-titlebar">备注</td>
				<td width="5%" class="table-titlebar">审核状态</td>
				<td width="5%" class="table-titlebar">申请日期</td>
				<td width="10%" class="table-titlebar">操作</td>
			</tr>
			<!-- 详细列表 -->
			<s:iterator id="memberList" value="memberList" var="blogList"
				status="status">
				<tr class="table_border_cell_bg">

					<%-- <td align="left" class="table-cell"><s:property value="id" />
					</td> --%>
					<td align="left" class="table-cell"><s:property
							value="hycardId" />
					</td>
					<td align="left" class="table-cell"><s:property value="hyname" />
					</td>
					<td align="center" class="table-cell"><s:property
							value="hyLevel" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="phoneNumber" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="identifyId" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="bankcardNumber" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="skrName" />
					</td>
					<td align="left" class="table-cell" onmouseover="display('<s:property
							value="id" />')" onmouseout="disappear('<s:property
							value="id" />')">
							<a>详情..</a> 
							<div style="display: none" id="<s:property
							value="id" />">
								<s:property value="shouhuoAddress" />
							</div>
							
							
					</td>
					<td align="left" class="table-cell"><s:property value="tjrId" />
					</td>
					<td align="left" class="table-cell"><s:property value="hyFee" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="inforFee" />
					</td>
					<td align="left" class="table-cell"><s:property
							value="totalMoney" />
					</td>
					<td align="left" class="table-cell"  onmouseover="display('<s:property
							value="hycardId" />')" onmouseout="disappear('<s:property
							value="hycardId" />')"   >

						
							<a>详情..</a> 
							<div style="display: none" id="<s:property
							value="hycardId" />">
								<s:property value="beizhu" />
							</div>
							 
						</td>
					<td align="center" class="table-cell"><s:if test="hyState==0"><span style="color:red">待审核</span></s:if>
						<s:if test="hyState==1">通过</s:if> <%-- <s:if
							test="hyState==2">未通过</s:if> --%>
					</td>
					<td align="center" class="table-cell"><s:date name="applyTime"
							format="yyyy-MM-dd HH:mm" />
					</td>
















					<td align="center" class="table-cell"><s:url id="url2"
							action="updateState">
							<s:param name="lytHuiyuan.id" value="id" />
						</s:url> 
						
						<s:if test="hyState==0">
						<a href="javascript:if(confirm('确认通过审核，使该用户成为正式会员？审核后将自动给用户发送短信通知成功！'))location='<s:property value="#url2"/>'">审核</a>
						<%-- <a href="<s:property value="#url2"/>">审核</a> --%></s:if>
						<%-- <s:if test="hyState==1">已通过</s:if> --%>
						
						
						
						
						&nbsp;&nbsp; <s:url id="url1"
							action="deleteHy">
							<s:param name="lytHuiyuan.id" value="id" />
						</s:url><a
						href="javascript:if(confirm('确认删除该条记录？删除后将不可恢复！'))location='<s:property value="#url1"/>'">删除</a>

					</td>
				</tr>

			</s:iterator>
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
					&nbsp;&nbsp;</td>
			</tr>
		</table>
		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td class="paeg_bar"></td>
			</tr>
		</table>
	</form>
</body>
</html>
