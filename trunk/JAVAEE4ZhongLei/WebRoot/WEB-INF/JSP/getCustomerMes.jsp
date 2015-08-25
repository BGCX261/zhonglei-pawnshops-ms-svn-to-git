<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>顾客情况表</title>
</head>

<body>
<table width="622" border="1" cellpadding="0" cellspacing="0"
	bordercolor="#000000">
	<col width="84" span="8" />
	<tr height="18">
		<td colspan="8" rowspan="2" height="36">顾客情况</td>
	</tr>
	<tr height="18">
	</tr>
	<tr height="18">
		<td width="37" height="18">姓名</td>
		<td colspan="3"><s:property value="customer.name" /></td>
		<td width="66">身份证号</td>
		<td width="265" colspan="3"><s:property value="customer.idcard" /></td>
	</tr>
	<tr height="18">
		<td height="18">电话</td>
		<td colspan="3"><s:property value="customer.phone" /></td>
		<td>住址</td>
		<td colspan="3"><s:property value="customer.address" /></td>
	</tr>
</table>
<p>&nbsp;</p>
<table width="627" border="1" cellpadding="0" cellspacing="0"
	bordercolor="#333333">
	<col width="95" span="7" />

	<tr height="18">
		<td height="18" width="95">
		<div align="center">物品</div>
		</td>
		<td width="95">
		<div align="center">金额</div>
		</td>
		<td width="95">
		<div align="center">起始</div>
		</td>
		<td width="95">
		<div align="center">截止</div>
		</td>
		<td width="95">
		<div align="center">月率</div>
		</td>
		<td width="95">
		<div align="center">规格和状况</div>
		</td>
		<td width="95">
		<div align="center">备注</div>
		</td>
	</tr>
	<s:iterator value="%{pawncheckSet}" status="st" id="tr">
		<tr height="18">
			<td colspan="7" height="18">
			<div align="center">当票号 ： <s:property value="id" /></div>
			</td>
		</tr>
		<s:iterator value="%{goods}" status="st" id="td">
			<tr height="18">
				<td height="18"><s:property value="loan.loan_name" /></td>
				<td><s:property value="total" /></td>
				<td><s:property value="indate" /></td>
				<td><s:property value="redate" /></td>
				<td><s:property value="rate" /></td>
				<td><s:property value="accessory" /></td>
				<td><s:property value="memo1" /></td>
			</tr>
		</s:iterator>
	</s:iterator>
</table>
<p>&nbsp;</p>
</body>
</html>
