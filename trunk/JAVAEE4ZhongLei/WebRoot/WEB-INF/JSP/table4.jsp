<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="choosDay" /> 帐务信息</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
	<col width="72" span="8" />
	<tr height="18">
		<td height="18" colspan="8">
		<div align="center">入当</div>
		</td>
	</tr>
	<tr height="18">
		<td height="18" width="72">
		<div align="center">当票号</div>
		</td>
		<td width="72">
		<div align="center">姓名</div>
		</td>
		<td width="72">
		<div align="center">身份证号</div>
		</td>
		<td width="72">
		<div align="center">起始日期</div>
		</td>
		<td width="72">
		<div align="center">期限</div>
		</td>
		<td width="72">
		<div align="center">截止日期</div>
		</td>
		<td width="72">
		<div align="center">典当金额</div>
		</td>
		<td width="72">
		<div align="center">费用</div>
		</td>
	</tr>
	<s:iterator value="%{newGoods}" status="st" id="tr1">
		<tr height="18">
			<s:iterator value="tr1" id="td1">
				<td height="18">
				<div align="center"><s:property value="td1" /></div>
				</td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
<br />
<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
	<col width="72" span="4" />
	<tr height="18">
		<td colspan="4" height="18" width="288">
		<div align="center">续当情况</div>
		</td>
	</tr>
	<tr height="18">
		<td height="18">
		<div align="center">当票号</div>
		</td>
		<td>
		<div align="center">截止日期</div>
		</td>
		<td>
		<div align="center">典当金额</div>
		</td>
		<td>
		<div align="center">费用</div>
		</td>
	</tr>
	<s:iterator value="%{newRecode}" status="st" id="tr2">
		<tr height="18">
			<s:iterator value="tr2" id="td2">
				<td height="18">
				<div align="center"><s:property value="td2" /></div>
				</td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
<br />

<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
	<col width="72" span="8" />
	<tr height="18">
		<td colspan="8" height="18" width="576">
		<div align="center">其他操作</div>
		</td>
	</tr>
	<tr height="18">
		<td height="18">
		<div align="center">当票号</div>
		</td>
		<td>
		<div align="center">姓名</div>
		</td>
		<td>
		<div align="center">身份证号</div>
		</td>
		<td>
		<div align="center">起始日期</div>
		</td>
		<td>
		<div align="center">期限</div>
		</td>
		<td>
		<div align="center">操作日期</div>
		</td>
		<td>
		<div align="center">典当金额</div>
		</td>
		<td>
		<div align="center">操作</div>
		</td>
	</tr>
	<s:iterator value="%{newOthers}" status="st" id="tr3">
		<tr height="18">
			<s:iterator value="tr3" id="td3">
				<td height="18">
				<div align="center"><s:property value="td3" /></div>
				</td>
			</s:iterator>
		</tr>
	</s:iterator>
</table>
</body>
</html>
