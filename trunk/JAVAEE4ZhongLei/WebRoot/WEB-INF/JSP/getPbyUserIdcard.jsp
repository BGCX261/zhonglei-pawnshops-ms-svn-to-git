<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>输入身份证号 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px">
<legend>Input--User ID</legend>
<table width="706" height="472" border="0">
	<tr>
		<td width="151">&nbsp;</td>
		<td width="383">&nbsp;</td>
		<td width="158">&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><s:form action="getCusList">
			<s:textfield label="用户身份证号码" name="customer.idcard" value="" />
			<s:submit />
		</s:form></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><s:form action="getCusList">
			<s:textfield label="用户姓名" name="customer.name" value="" />
			<s:submit />
		</s:form></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>

</fieldset>
</body>
</html>
