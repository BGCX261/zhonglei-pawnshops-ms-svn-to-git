<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择 众磊典当系统</title>
</head>

<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Select</legend>

<br />

<table width="699" height="458" border="0">
	<tr align="center">
		<td width="133" height="454">&nbsp;</td>
		<td width="432">请输入要废的当票号 ： <input type="text" name="date"
			id="date" /><br />
		<br />
		<br />
		<a href="BlankDo.action"
			onclick="document.getElementById('up').href='BlankDo.action?pawncheck_id='+document.getElementById('date').value"
			id="up">废当票</a></td>
		<td width="120">&nbsp;</td>
</table>

</fieldset>
</body>
</html>
