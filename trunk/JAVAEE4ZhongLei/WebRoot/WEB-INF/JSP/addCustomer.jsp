<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加客户 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Add--Customer</legend>
<s:form action="addCustomerAndnext">
	<table height="100">
		<tr>
			<td><span
				style="font-size: 14px; font-style: italic; color: #FF0000;">请核对当票号</span>
			<s:actionerror cssClass="error" /> <s:textfield label="当票流水号"
				name="pawncheckNO.pawncheckNO" value="%{pawncheckNO.pawncheckNO}"
			/></td>
		</tr>
	</table>
	<fieldset><legend>Customer--Info</legend>
	<li><s:textfield label="客户身份证号" name="customer.idcard"
		value="%{customer.idcard}" /><span
		style="font-size: 12px; font-style: italic; color: #FF0000;">[若是老客户仅填此]</span></li>
	<li><s:textfield label="客户姓名" name="customer.name"
		value="%{customer.name}" /></li>
	<li><s:textfield label="客户电话" name="customer.phone"
		value="%{customer.phone}" /></li>
	<li><s:textfield label="客户地址" name="customer.address"
		value="%{customer.address}" /></li>
	<li><s:radio list="{'新','旧'}" name="isnew" /> 客户</li>
	<s:submit /></fieldset>
</s:form> <a
	href="<s:url value="getTempPawncheck.action" namespace="operator" />"></a>
</fieldset>
</body>
</html>
