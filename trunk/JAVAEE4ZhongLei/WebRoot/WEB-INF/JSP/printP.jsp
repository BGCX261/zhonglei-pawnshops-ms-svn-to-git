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
<!-- a href="printP.action">打印当票</a--> <br />
<br />
<br />
<s:form action="printP.action">
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#999999">
	<col width="72" />
	<col width="158" span="3" />
	<tr height="18">
		<td height="18" width="72">当票号</td>
		<td colspan="3" width="474"><s:property
			value="%{#session.pawncheckNO.pawncheckNO}" /></td>
	</tr>
	<tr height="18">
		<td height="18"></td>
		<td colspan="3"><s:textfield label="客户姓名" name="customer.name"
		value="%{customer.name}" /></td>
	</tr>
	<tr height="18">
		<td height="18"></td>
		<td colspan="3"><s:textfield label="客户身份证号" name="customer.idcard"
		value="%{customer.idcard}" /></td>
	</tr>
	<tr height="18">
		<td height="18"></td>
		<td colspan="3"><s:textfield label="客户电话" name="customer.phone"
		value="%{customer.phone}" /></td>
	</tr>
	<tr height="18">
		<td height="18"></td>
		<td colspan="3"><s:textfield label="客户地址" name="customer.address"
		value="%{customer.address}" /></td>
	</tr>
	<tr height="18">
		<td height="18">月费率</td>
		<td colspan="3"><s:property value="goods.rate" /></td>
	</tr>
</table>
<table border="2" cellpadding="0" cellspacing="0" bordercolor="#999999">
	<col width="72" />
	<col width="158" span="3" />
	<tr height="18">
		<td height="18" width="72">物品</td>
		<td width="158">估价</td>
		<td width="158">数量</td>
		<td width="158">规格和状况</td>
	</tr>

	<s:iterator value="%{goodsList}" status="st" id="tr">
		<tr height="18">
			<td height="18"><s:property value="#st.count" /></td>
			<td><input value="<s:property value="total"/>"  name="goodArr[<s:property value="#st.count-1" />].total" /></td>
			<td><input name="goodArr[<s:property value="#st.count-1" />].val" value="<s:property value="val"/>" /></td>
			<td><input name="goodArr[<s:property value="#st.count-1" />].accessory" value="<s:property value="accessory"/>" /></td>
		</tr>
	</s:iterator>
</table>
<s:submit align="left"></s:submit>
</s:form>
截止日期 ：<s:property value="endDate" /> <br />
<br />
<br />
<a href="createFirst.action">重新完成当票</a></fieldset>
</body>
</html>
