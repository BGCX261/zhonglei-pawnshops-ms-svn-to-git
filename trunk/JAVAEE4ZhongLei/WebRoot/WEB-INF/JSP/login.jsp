<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>请登陆 众磊典当管理系统 artern.cn (c) 2008</title>
<style type="text/css">
<!--
a,td {
	color: #FFFFFF;
}

.title {
	font-size: 16px;
	font-weight: bold;
	color: #1D387D;
	font-family: Arial, Helvetica, sans-serif;
}

.t {
	padding-top: 120px;
	padding-left: 220px;
}
-->
</style>
</head>
<body scroll="no" onLoad="init()"
	oncontextmenu="self.event.returnValue=false" ondrag="return false">
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0" bgcolor="#3F63AD">
	<tr bgcolor="#1D387D">
		<td width="7%" align="center" background="images/top_bg.jpg"
			bgcolor="#1D387D"><span class="topbarbig"><img
			src="images/tut.gif" width="40" height="40" align="absmiddle"></span></td>
		<td width="93%" height="60" background="images/top_bg.jpg"
			bgcolor="#1D387D">Login Console<br>
		<span class="topbarbig">ZL-H Management System</span></td>
	</tr>
	<tr>
		<td height="3" colspan="2" bgcolor="#9AAEF5"></td>
	</tr>
	<tr>
		<td colspan="2" valign="top" class="t">
		<table width="400" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td height="70" colspan="2"><span class="title">众磊典当管理系统
				<br> 登录以使用 ZhongLei Hock Management System
				</span></td>
			</tr>
			<tr>
				<td><s:actionerror cssClass="error" /> <s:form
					action="processLogin">
					<s:textfield name="id" label="员工号" />
					<s:password name="password" label="密码 " />
					<s:submit />
				</s:form></td>
			</tr>
			<tr>
				<td height="60">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="3" colspan="2" bgcolor="#9AAEF5"></td>
	</tr>
	<tr>
		<td height="60" class='left-20' background="images/bottom_bg.jpg"><img
			src='images/close.jpg' width='24' height='24' class='hand'
			onClick='window.close()' title='关闭'></td>
		<td align="right" background="images/bottom_bg.jpg">Copyright&nbsp;&copy;&nbsp;artern.cn
		All rights reserved.&nbsp;&nbsp;</td>
	</tr>
</table>
</body>
</html>