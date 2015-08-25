<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印 众磊典当系统</title>
</head>

<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>PRINT</legend>
<a href="printR.action">打印续当票</a> <br />
<br />
<br />
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#999999">
	<col width="103" />
	<col width="221" />
	<tr height="18">
		<td height="18" width="103">当票号</td>
		<td width="221"><s:property value="pawncheckNO" /></td>
	</tr>
	<tr height="18">
		<td height="18">延长月数</td>
		<td><s:property value="duration" /></td>
	</tr>
	<tr height="18">
		<td height="18">物品总值</td>
		<td><s:property value="sum" /></td>
	</tr>
	<tr height="18">
		<td height="18">折当率</td>
		<td><s:property value="rate" /></td>
	</tr>
	<tr height="18">
		<td height="18">综合费用</td>
		<td><s:property value="si" /></td>
	</tr>
</table>

<br />
<br />
<br />
<a href="creatRecord.action?status=addRecord">重新制定续当</a></fieldset>
</body>
</html>
