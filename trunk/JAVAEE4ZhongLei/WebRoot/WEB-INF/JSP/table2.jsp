<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>典当服务行典行当物品登记簿 众磊典当系统</title>
</head>

<body>
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
	<col width="50" />
	<col width="89" />
	<col width="53" />
	<col width="130" />
	<col width="153" />
	<col width="89" />
	<col width="61" />
	<col width="89" />
	<tr height="18">
		<td colspan="8" rowspan="2" height="36" width="714" align="center">天津市典当服务行典行当物品登记簿</td>
	</tr>
	<tr height="18">
	</tr>
	<tr height="18" align="center">
		<td height="18">日期</td>
		<td>当票号</td>
		<td>姓名</td>
		<td>地址</td>
		<td>身份证</td>
		<td>物品名称</td>
		<td>金额</td>
		<td>物品状态</td>
	</tr>
	<s:iterator value="%{temp}" status="st" id="tr">
		<tr align="center">
			<s:iterator value="tr" id="td">
				<td><s:property value="td" /></td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
</body>
</html>
