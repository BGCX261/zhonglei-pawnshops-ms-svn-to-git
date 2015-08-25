<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在当物品月盘点表 众磊典当系统</title>
</head>

<body>
<table border="1" align="left" cellpadding="0" cellspacing="0"
	bordercolor="#000000">
	<col width="137" />
	<col width="198" />
	<col width="55" />
	<col width="176" />
	<col width="143" />
	<tr height="18">
		<td colspan="5" rowspan="2" height="36" width="709">
		<div align="center"><strong>在当物品月盘点表</strong></div>
		</td>
	</tr>
	<tr height="18">
	</tr>
	<tr height="18">
		<td colspan="5" height="18"><s:property value="%{date}" /></td>
	</tr>
	<tr height="18" align="center">
		<td height="18">当票号</td>
		<td>物品名</td>
		<td>件数</td>
		<td>金额</td>
		<td>状态</td>
	</tr>
	<s:iterator value="%{temp}" status="st" id="tr">
		<tr height="18" align="center">
			<s:iterator value="tr" id="td">
				<td height="18"><s:property value="td" /></td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
</body>
</html>
