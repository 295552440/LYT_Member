<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>main</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<script src="../js/jquery-1.8.2.js" type="text/javascript" >
</script>
<script type="text/javascript">

	//卡号和类型查询；
	function queryByTypeHy() {
		var hycardId = $("#hycardId").value;
		var fanliType = $("#fanliType").val();
		alert(hycardId);
		alert(fanliType);
		if (hycardId == "") {
			alert("id不能为空");
			$("#msgkey").innerHTML = "输入不能为空！";
			return false;
		} else {
			window.location.href = "queryByTypeHy?hycardId=" + hycardId
					+ "&fanliType=" + fanliType;
			return true;
		}
	}
        function queryByCardId(){  
            $.ajax({  
                type : "POST",  
                dataType : "json", 
                data : {hycardId:"31000"},
                url : "queryByCardId",  
                success : function(data) { 
                	alert(state); 
                	alert(data.LytHuiyuan.hycardId);
                      $.each(data.LytHuiyuan, function(i, one) {  
            				result = "<tr align='center'><td>"+one.id+"</td><td>"+one.hyname+"</td><td>"+one.hycardId+"</td></tr>";  
           			 $(result).appendTo("#deptListDiv");  
      			  });  
                },
                error : function(data) {  
                	alert(data.LytHuiyuan);
                      $.each(data.LytHuiyuan, function(i, one) {  
            				result = "<tr align='center'><td>"+one.id+"</td><td>"+one.hyname+"</td><td>"+one.hycardId+"</td></tr>";  
           			 $(result).appendTo("#deptListDiv");  
      			  });  
                }
            });  
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
					</select> <input name="hycardId" type="text" id="hycardId" size="21" /> </span></td>
				<td><span class="oper-bar-text"> 类型：</span><span
					class="title_bar"><select name="fanliType" id="fanliType"
						class="form_select">
							<option value="" selected>排列顺序</option>
							<option value="0">0</option>
							<option value="1">1</option>
					</select> </span> <input name="Submit5" type="button" class="form-buttun"
					onclick="return queryByTypeHy()" value="搜索" /> <a
					href="queryByTypeHy?hycardId=31000&fanliType=1">查询</a></td>


			</tr>
		</table>
	</form>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="oper-bar">
		<tr>

			<td width="15%" align="left">&nbsp;<span class="oper-bar-text">消息框&nbsp;<img
					src="../images/admin/oper/msg.png" alt="消息" width='20' height='20'
					border="0"></img> </span>
			</td>
			<td width="20%" align="center">&nbsp;<span style="color: red">共查询出
					条记录！ </span>
			</td>
			<td width="20%" align="right">&nbsp;<span style="color: red"
				id="msgkey"></span>
			</td>
		</tr>
	</table>
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
				<td class="table-cell">${flset.lytHuiyuanByBtjrId.hycardId }</td>
				<td class="table-cell">${flset.lytHuiyuanByTjrId.hycardId }</td>
				<td class="table-cell">${flset.tjTime }</td>
				<td class="table-cell">${flset.fanliState }</td>
				<td class="table-cell">${flset.fanliMoney }</td>
				<td class="table-cell">${flset.fanliType }</td>
				<td class="table-cell">${flset.fanliTime }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="javascript:queryByCardId()">查询个人信息</a>
	<a href="queryByCardId?hycardId=31000">查询个人信息</a>
	<div id="deptListDiv"></div>
	<table width="99%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="page_bar"></td>
		</tr>
	</table>
</body>
</html>
