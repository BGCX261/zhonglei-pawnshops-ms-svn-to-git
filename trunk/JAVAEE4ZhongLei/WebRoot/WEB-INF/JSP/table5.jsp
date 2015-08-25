<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>状态分类表 众磊典当系统</title>
</head>

<body>
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000"
	bgcolor="#FFFFFF">
	<col width="72" span="8" />
	<tr height="18">
		<td height="18" width="72">当票号</td>
		<td width="72">姓名</td>
		<td width="72">身份证</td>
		<td width="72">起始日期</td>
		<td width="72">期限</td>
		<td width="72">到期日期</td>
		<td width="72">典当金额</td>
		<td width="72">状态</td>
	</tr>
	<s:iterator value="%{temp}" status="st" id="tr">
		<tr height="18">
			<s:iterator value="tr" id="td">
				<td height="18"><s:property value="td" /></td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
</body>
</html>