<%@page contentType="text/html; charset=utf-8" language="java"  errorPage=""%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="众磊典当管理系统" /> artern.cn (c) 2008</title>
<style type="text/css">
<!--
body {
	font: 100% Verdana, Arial, Helvetica, sans-serif;
	/*background: #666666;*/
	margin: 0; /* 最好将 body 元素的边距和填充设置为 0 以覆盖不同的浏览器默认值 */
	padding: 0;
	text-align: center;
	/* 在 IE 5* 浏览器中，这会将容器居中。文本随后将在 #container 选择器中设置为默认左对齐 */
	color: #000000;
	background-color: #3F63AD;
}

.twoColLiqLtHdr #container {
	width: 1000px; /* 这将创建一个占据 80% 浏览器宽度的容器 */
	height: 700px;
	margin: 0 auto; /* 自动边距（与宽度一起）会将页面居中 */
	border: 1px solid #000000;
	text-align: left; /* 这将覆盖 body 元素上的“text-align: center”。 */
	background-color: #F0F0F0;
}

.twoColLiqLtHdr #header {
	height: 58px;
	/* 此填充会将出现在它后面的 div 中的元素左对齐。如果 #header 中使用的是图像（而不是文本），您最好删除填充。 */
	background-color: #3F63AD;
	background-image: url(../images/top_bg.jpg);
}

.twoColLiqLtHdr #header span {
	
}

/* sidebar1 提示：
1. 由于我们使用的是百分比，因此最好不要在侧栏中使用填充。它将会新增至宽度，而让符合标准的浏览器建立未知的实际宽度。 
2. 如果为 div 中的元素设置左边距和右边距，则会在 div 边缘和这些元素之间产生空白，如“.twoColLiqLtHdr #sidebar1 p”规则中所示。
3. 由于 Explorer 会在父元素显示之后计算宽度，因此基于百分比的栏有时会出现无法解释的错误。如果您需要更可预见的结果，可选择改为以像素为单位设置栏的大小。
*/
.twoColLiqLtHdr #sidebar1 {
	float: left;
	width: 20%; /* 由于此元素是浮动的，因此必须指定宽度 */
	height: 558px; /* 顶部和底部的填充将在该 div 中产生视觉空间 */
	background-color: #F0F0F0;
}

/* mainContent 提示：
1. mainContent 和 sidebar1 之间的空白是由 mainContent div 的左边距创建的。无论 sidebar1 div 中包含多少内容，都将保留栏空白。如果您希望在 #sidebar1 中的内容结束时，用 #mainContent div 的文本填充 #sidebar1 空白，则可以删除此左边距。
2. 为了避免在所支持的最小分辨率 800 x 600 下出现“浮动下降”，mainContent div 中的元素（包括图像）不应大于 430 像素。
3. 在下面的 Internet Explorer 条件注释中，zoom 属性用来赋予 mainContent“hasLayout”。这会避免几个特定于 IE 的错误。
*/
.twoColLiqLtHdr #mainContent {
	margin: 10px 0 10px 210px; /* 右边距可以用百分比或像素来指定，它会在页面的右下方产生空白。 */
	width: 774px;
}

.twoColLiqLtHdr #footer {
	padding: 0 10px; /* 此填充会将它上面 div 中的所有元素左对齐。 */
	background: #3F63AD;
	height: 58px;
	background-color: #3F63AD;
	background-image: url(../images/bottom_bg.jpg);
}

/* 要重用的各种类 */
.fltrt { /* 此类可用来使页面中的元素向右浮动。浮动元素必须位于页面上要与之相邻的元素之前。 */
	float: right;
	margin-left: 8px;
}

.fltlft { /* 此类可用来使页面上的元素向左浮动 */
	float: left;
	margin-right: 8px;
}

.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
	clear: both;
	height: 0;
	font-size: 1px;
	line-height: 0px;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
-->
</style>
<!--[if IE]>
<style type="text/css"> 
/* 请将所有版本的 IE 的 css 修复放在这个条件注释中 */
.twoColLiqLtHdr #sidebar1 { padding-top: 30px; }
.twoColLiqLtHdr #mainContent { zoom: 1; padding-top: 15px; }
/* 上面的专用 zoom 属性为 IE 提供避免错误所需的 hasLayout */
</style>
<![endif]-->
<s:head />
</head>

<body class="twoColLiqLtHdr"
	oncontextmenu="self.event.returnValue=false"
	onselectstart="self.event.returnValue=false">

<div id="container">
<div id="header">
<div style="float: left; width: 40px; margin: 10px 0 0 20px;"><img
	src="../images/tut.gif" /></div>
<div
	style="float: left; width: 800px; margin: 11px 0 0 20px; color: #FFFFFF">ZL-H
Management System</div>
<div
	style="float: left; width: 800px; margin: 1px 0 0 20px; color: #FFFFFF"><decorator:title
	default="众磊典当管理系统 artern.cn (c) 2008" /></div>
<!-- end #header --></div>
<div style="background-color: #94ADEF; height: 2px; overflow: hidden;"></div>
<div id="sidebar1">
<div style="width: 100%; height: 25%">
<div align="center"><a
	href="<s:url value="createFirst.action" namespace="operator" />"><img
	src="../images/icon/DataAdd.gif" width="44" height="44"
	style="margin: 55px 75px 15px 75px; border: 0px" /></a><strong>建 当</strong></div>
</div>
<div style="width: 100%; height: 25%">
<div align="center"><a
	href="<s:url value="creatRecord.action?status=addRecord" namespace="operator" />"><img
	src="../images/icon/addGreen.gif" width="44" height="44"
	style="margin: 55px 75px 15px 75px; border: 0px" /></a><strong>续 当</strong></div>
</div>
<div style="width: 100%; height: 25%">
<div align="center"><a
	href="<s:url value="creatRecord.action?status=redeemGoods" namespace="operator" />"><img
	src="../images/icon/DormAssgin.gif" width="44" height="44"
	style="margin: 55px 75px 15px 75px; border: 0px" /></a><strong>赎 当</strong></div>
</div>
<div style="width: 100%; height: 25%">
<div align="center"><a
	href="<s:url value="getPbyUserIdCard.action" namespace="operator" />"><img
	src="../images/icon/RegOldStu.gif" width="32" height="32"
	style="margin: 55px 75px 15px 75px; border: 0px" /></a><strong>
顾客信息</strong></div>
</div>
<!-- end #sidebar1 --></div>
<div id="mainContent">
<div style="height: 568px"><decorator:body /></div>
<!-- end #mainContent --></div>
<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><!--br class="clearfloat" /-->
<div style="background-color: #94ADEF; height: 2px; overflow: hidden;"></div>
<div id="footer">
<div style="float: left; width: 280px; margin: 10px 0 0 20px;"><img
	src="../images/struts.gif" width="77" height="33" /><img
	src="../images/spring.gif" width="75" height="33" /><img
	src="../images/hibernate.png" width="119" height="33" /></div>
<div
	style="float: left; width: 405px; margin: 20px 20px 20px 20px; color: #FFFFFF; font-size: 12px;">artern.cn
(c) 2008 版权所有 <s:property value="%{#session.userId}" /></div>
<div style="float: left; height: 50px; width: 223px">
<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="../images/icon/1.gif" width="50" height="30"
			class="hand" /></td>
		<td><img src="../images/icon/2.gif" width="32" height="30"
			class="hand" /></td>
		<td><img src="../images/icon/3.gif" width="32" height="30"
			class="hand" /></td>
		<td><a
			href="<s:url value="welcome.action" namespace="operator" includeParams="all"/>"><img
			src="../images/icon/4.gif" alt="首页" width="31" height="30" border="0" /></a></td>
		<td><img src="../images/icon/5.gif" alt="帮助" width="33"
			height="30" class="hand" /></td>
		<td><a href="/Logout.action"><img src="../images/icon/6.gif"
			alt="注销登录" width="45" height="30" border="0" /></a></td>
	</tr>
</table>
</div>
<!-- end #footer --></div>
<!-- end #container --></div>
</body>
</html>
