<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>典当业务月统计表 众磊典当系统</title>
</head>

<body>
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
	<col width="142" span="5" />
	<tr height="18">
		<td colspan="5" rowspan="2" height="36" width="710" align="center"><strong>典当业务月统计表</strong></td>
	</tr>
	<tr height="18">
	</tr>
	<tr height="18">
		<td colspan="5" height="18"><s:property value="%{date}" /></td>
	</tr>
	<tr height="18" align="center">
		<td rowspan="2" height="36">项目</td>
		<td colspan="2">典当成交额</td>
		<td colspan="2">其中：绝当</td>
	</tr>
	<tr height="18" align="center">
		<td height="18">笔数</td>
		<td>成交额</td>
		<td>笔数</td>
		<td>金额</td>
	</tr>
	<s:iterator value="%{temp_}" status="st" id="one">
		<tr height="18" align="center">
			<td height="18"><s:property value="key" /></td>
			<s:iterator value="value" id="td">
				<td><s:property value="td" /></td>
			</s:iterator>
			<td>0</td>
			<td>0.00</td>
		</tr>
	</s:iterator>
</table>
</body>
</html>
