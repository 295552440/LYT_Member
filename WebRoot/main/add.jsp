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
	
	
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/message.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript"
	src="js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function gainHyFee(level, data) {
		/* alert($("input[name='lytHuiyuan.hyLevel']:checked").val());*/
		$("#hyFee").val(data);
		confirm("请确认您所选级别为：" + level + ",费用为：" + data);
		gainTotalFee();
	}

	function gainTotalFee() {
		var data = parseFloat($.trim($("#inforFee").val()));
		data += parseFloat($("#hyFee").val());
		$("#totalMoney").val(data);
		alert(parseFloat($("#hyFee").val()));
	}

	function tijiao() {
		var hyLevel = $("input[name='hyLevel']:checked").val();
		var hyname = $.trim($("#hyname").val());
		var hyFee = $.trim($("#hyFee").val());
		var phoneNumber = $.trim($("#phoneNumber").val());
		var identifyId = $.trim($("#identifyId").val());
		var tjrId = $.trim($("#tjrId").val());
		var bankcardNumber = $.trim($("#bankcardNumber").val());
		var inforFee = $.trim($("#inforFee").val());
		var shouhuoAddress = $.trim($("#shouhuoAddress").val());
		var totalMoney = $.trim($("#totalMoney").val());
		var skrName = $.trim($("#skrName").val());
		var beizhu = $.trim($("#beizhu").val());
		var params = {
			"lytHuiyuan.hyLevel" : hyLevel,
			"lytHuiyuan.phoneNumber" : phoneNumber,
			"lytHuiyuan.hyname" : hyname,
			"lytHuiyuan.hyFee" : hyFee,
			"lytHuiyuan.identifyId" : identifyId,
			"lytHuiyuan.tjrId" : tjrId,
			"lytHuiyuan.bankcardNumber" : bankcardNumber,
			"lytHuiyuan.inforFee" : inforFee,
			"lytHuiyuan.shouhuoAddress" : shouhuoAddress,
			"lytHuiyuan.totalMoney" : totalMoney,
			"lytHuiyuan.skrName" : skrName,
			"lytHuiyuan.beizhu" : beizhu
		};
		if (checkApply(hyname, phoneNumber, identifyId, tjrId, bankcardNumber,
				shouhuoAddress)) {
			$.ajax({
				url : "main/lytHuiyuanApply",
				type : "post",
				data : params,
				dataType : "json",
				success : function(data) {
					var msg = data.message;
					alert(msg);
				},
				error : function() {
					alert("服务器异常");
				}
			});
		}

	}
</script>

</head>

<body>

<div class="header">
		<div class="header-top">
			<div class="wrap">
				<div class="logo">
					<a href="index.html"><img src="<%=request.getContextPath()%>/main/web/images/logo.png" alt="" />
					</a>
				</div>
				<div class="cssmenu">
					<ul id="nav">
						<li class="current"><a href="<%=request.getContextPath()%>/main/web/index.jsp">首页</a>
						</li>
						<li class="current"><a
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
	<form>
		<table width="31%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table-frame">
			<tr class="table_border_cell_bg">
				<td class="table-cell">会员级别</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					name="hyLevel" id="DC" type="radio" value="钻卡"
					onclick="gainHyFee('钻卡',1980);" checked="checked"><label
					for="DC">钻卡<u>1980￥</u></label> <input name="hyLevel" id="GC"
					type="radio" value="金卡" onclick="gainHyFee('金卡',990);"> <label
					for="GC">金卡<u>990￥</u></label> <input name="hyLevel" id="SC"
					type="radio" value="银卡" onclick="gainHyFee('银卡',198);"><label
					for="SC">银卡<u>198￥</u></label> <input name="hyFee" id="hyFee"
					type="hidden"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">会员姓名</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="hyname" id="hyname"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">手机号</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="phoneNumber" id="phoneNumber"></td>
			</tr>
			<!-- <tr class="table_border_cell_bg">
				<td class="table-cell">日期</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					class="Wdate" type="text" name="lytHuiyuan.applyTime"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"></td>
			</tr> -->
			<tr class="table_border_cell_bg">
				<td class="table-cell">身份证号</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="identifyId" id="identifyId"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">推荐人卡号</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="tjrId" id='tjrId'>
					<span id="err"></span>
				</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">银行账号</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="bankcardNumber" id="bankcardNumber"></td>

			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">信息费（邮费）</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="inforFee" id="inforFee" value=0.00
					onblur="gainTotalFee()">￥</td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">收货地址</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="shouhuoAddress" id="shouhuoAddress"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">合计金额</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="totalMoney" id="totalMoney" readonly="readonly"
					value=1980></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">收款人姓名</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="skrName" id="skrName"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td class="table-cell">备注</td>
				<td class="table-cell" style="padding:3px" align="left"><input
					type="text" name="beizhu" id="beizhu"></td>
			</tr>
			<tr class="table_border_cell_bg">
				<td colspan="2" class="table-cell"><h2 align="center">声明：</h2>

					<p align="justify">
						&nbsp;&nbsp;填写以上信息必须真实有效，所填信息未经公司允许任何人不得修改，如检查无误请点击提交。</p></td>
			</tr>
		</table>
		<p align="center">
			<input type="button" value="提交" onclick="tijiao();">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
				value="取消">
		</p>
		<font size="3" color="red">${msg }</font>
	</form>
</body>
</html>
