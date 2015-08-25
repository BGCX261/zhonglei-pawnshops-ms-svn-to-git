<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当品列表 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Goods--List</legend>
<s:form action="%{status}">
	<s:checkboxlist list="%{goodsMap}" listKey="key" listValue="value"
		name="value" label="选择物品" labelposition="top" value="%{value}" />
	<s:textfield name="duration" label="延长当期（月）" value="1" />
	<s:submit />
</s:form>

<h5>物品状态的对照表示： AfterEndDay: 物品超过当期；BeforeEndDay：物品还没有过当期</h5>
<h5 style="color: #FF0000;">请勿对这些物品操作： BeSold：物品已经被卖出；Redeemed:
物品已被赎当</h5>

</fieldset>
</body>
</html>
