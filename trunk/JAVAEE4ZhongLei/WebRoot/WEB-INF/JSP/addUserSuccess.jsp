<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新员工信息 众磊典当系统</title>
</head>

<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Clerk
Info</legend> <br />
<br />
<br />
<br />
<strong style="color: #FF0000">员工号为： <s:property
	value="clerk.id" /> 请备案记牢</strong><br />
<br />
<s:textfield label="姓名" name="clerk.name" value="%{clerk.name}" /> <br />
<br />
<s:textfield label="密码" name="clerk.psw" value="%{clerk.psw}" /></fieldset>
</body>
</html>
