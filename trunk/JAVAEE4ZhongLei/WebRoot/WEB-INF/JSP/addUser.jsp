<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加员工 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Add--Clerk</legend>
<s:form action="doAddUser">
	<s:textfield label="姓名" name="clerk.name" />
	<s:textfield label="密码" name="clerk.psw" />
	<s:radio list="{'admin','operator'}" name="clerk.power" label="权限" />
	<s:submit />
</s:form></fieldset>
</body>
</html>
