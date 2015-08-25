<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择可获得的表格 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Select--Table</legend>

<br />

<table width="699" height="358" border="0">
	<tr>
		<td width="133" height="249">&nbsp;</td>
		<td width="432">
		<p>&nbsp;</p>
		<p>请输入查询月份 ： <input type="text" name="date" id="date" />
		(yyyy-xx)</p>
		<ul>
			<li><a href="#"
				onclick="targeturl='getTable1.action?date='+document.getElementById('date').value;newwin=window.open('', '', 'toolbar=no , menubar=no, scrollbars=yes,resizable=yes , location=no, status=no');newwin.focus();newwin.moveTo(0, 0);newwin.resizeTo(screen.width, screen.height - 25);newwin.location = targeturl;return false;">在当物品月盘点表</a></li>
		</ul>
		<br />
		<ul>
			<li><a href="#"
				onclick="targeturl='getTable2.action?date='+document.getElementById('date').value;newwin=window.open('', '', 'toolbar=no , menubar=no, scrollbars=yes,resizable=yes , location=no, status=no');newwin.focus();newwin.moveTo(0, 0);newwin.resizeTo(screen.width, screen.height - 25);newwin.location = targeturl;return false;">典当服务行典行当物品登记簿</a></li>
		</ul>
		<br />
		<ul>
			<li><a href="#"
				onclick="targeturl='getTable3.action?date='+document.getElementById('date').value;newwin=window.open('', '', 'toolbar=no , menubar=no, scrollbars=yes,resizable=yes , location=no, status=no');newwin.focus();newwin.moveTo(0, 0);newwin.resizeTo(screen.width, screen.height - 25);newwin.location = targeturl;return false;">典当业务月统计表</a></li>
		</ul>
		<p>&nbsp;</p>
		</td>
		<td width="120">&nbsp;</td>
	</tr>
	<tr>
		<td height="96">&nbsp;</td>
		<td><select name="status" size="1" id="status">
			<option value="BeforeEndDay">在当</option>
			<option value="AfterEndDay">过当期</option>
			<option value="Redeemed">被赎当</option>
			<option value="BeSold">被绝当</option>
		</select> <a href="#"
			onclick="targeturl='getTable5.action?status='+document.getElementById('status').value;newwin=window.open('', '', 'toolbar=no , menubar=no, scrollbars=yes,resizable=yes , location=no, status=no');newwin.focus();newwin.moveTo(0, 0);newwin.resizeTo(screen.width, screen.height - 25);newwin.location = targeturl;return false;">根据物品状态查询</a>
		<br />
		<br />
		<br />
		<br />
		<s:form>
			<s:datetimepicker name="choosDay" label="要查询的日期" value="today"
				id="choosDay" />
			<a href="#"
				onclick="targeturl='getTable4.action?choosDay='+dojo.widget.byId('choosDay').getValue();newwin=window.open('', '', 'toolbar=no , menubar=no, scrollbars=yes,resizable=yes , location=no, status=no');newwin.focus();newwin.moveTo(0, 0);newwin.resizeTo(screen.width, screen.height - 25);newwin.location = targeturl;return false;">根据日期查询</a>
		</s:form></td>
		<td>&nbsp;</td>
	</tr>

</table>

<p></p>
</fieldset>
</body>
</html>
