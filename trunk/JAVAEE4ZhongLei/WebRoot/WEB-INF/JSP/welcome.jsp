<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome Login 众磊典当系统</title>
</head>
<body>
<table width="720" height="495" border="1" align="left">
	<tr>
		<td>
		<table width="100%">
			<tr>
				<td width="247"><img src="../images/dong.jpg" width="207"
					height="212" style="margin: 5px 20px 5px 20px;" /></td>
				<td width="443">
				<h3>众磊典当提醒您：</h3>
				<p align="center">以礼迎客，诚信待人</p>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="103">
		<fieldset><legend>User--Info</legend>
		<table width="666" height="87" style="margin-left: 50px">
			<tr>
				<td width="34%" height="58">姓名：<s:property value="clerk.name" /></td>
				<td width="33%">员工号：<s:property value="%{#session.userId}" /></td>
				<td width="33%">权限：<s:property value="clerk.power" /></td>
			</tr>
			<tr height="2px">
				<td colspan="3" align="right"><span
					style="font-size: small; font-style: italic; color: #FF0000;">若不是您或信息不全，请退出后重新进入</span></td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td height="100">&nbsp;</td>
	</tr>
	<tr>
		<td height="46"><img src="../images/nondynamic.gif" width="16"
			height="16" style="margin-left: 30px; margin-right: 5px" /><span
			style="color: #FF0000">当前日期为<s:date name="date"
			format="yyyy-MM-dd" nice="false" />，请核对，以免影响系统运行，及数据安全</span></td>
	</tr>
</table>
</body>
</html>
