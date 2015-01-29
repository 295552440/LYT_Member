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
<%-- <base href="<%=basePath%>"> --%>

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../../css/admin/style.css" rel="stylesheet" type="text/css">
<link href="../../css/admin/menu_tab.css" rel="stylesheet"
	type="text/css">
<link href="../../css/admin/menu.css" rel="stylesheet" type="text/css">
<script src="../../js/admin/common.js"></script>
<script src="../../js/admin/page_init.js"></script>
<script src="../../js/admin/fw.js"></script>

<script type="text/JavaScript">

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

</script>


<script>

var currSelectTab = "";

function setCurrSelectTab(tabID){
	var lastSelect = currSelectTab;
	currSelectTab = tabID;
	
	if(lastSelect != ""){
		mouseOutTag(lastSelect);
	}
	
}

function mouseOverTag(tabID){
	if(currSelectTab == tabID){
		return;
	}
	
	var tagLeft = eval("document.all." + tabID + "_left");
	var tagBg = eval("document.all." + tabID + "_bg");
	var tagRight = eval("document.all." + tabID + "_right");
	
	tagLeft.className="tab-left-mouseover";
	tagBg.className="tab-bg-mouseover";
	tagRight.className="tab-right-mouseover";
}

function mouseOutTag(tabID){
	if(currSelectTab == tabID){
		return;
	}
	
	var tagLeft = eval("document.all." + tabID + "_left");
	var tagBg = eval("document.all." + tabID + "_bg");
	var tagRight = eval("document.all." + tabID + "_right");
	
	tagLeft.className="tab-left-mouseout";
	tagBg.className="tab-bg-mouseout";
	tagRight.className="tab-right-mouseout";
}



</script>
</head>

<body
	onLoad="loadImages('../../images/admin/menu_tab_left.gif,../../images/admin/menu_tab_bg.gif,../../images/admin/menu_tab_tabbg.gif,../../images/admin/menu_tab_right.gif,../../images/admin/menu_tab_left2.gif,../../images/admin/menu_tab_tabbg2.gif,../../images/admin/menu_tab_right2.gif,../../images/admin/menu_tab_split_line.gif')">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="bg"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="10%" align="center" class="text">&nbsp;</td>
						<td width="72%"><table border="0" cellspacing="0"
								cellpadding="0">
								<tr>

								</tr>
							</table>
						</td>
						<td width="6%" align="right"></td>
						<td width="12%" align="right"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
