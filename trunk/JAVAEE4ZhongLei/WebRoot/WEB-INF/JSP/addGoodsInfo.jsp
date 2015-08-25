<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>填写典当物品信息 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Add--GoodsInfo</legend>

<s:form action="addGoods">
	<s:textfield label="总金额" name="goods.total" value="" />
	<s:textfield label="手续费率" name="goods.rate" value="0.045" />
	<s:textfield label="物品个数" name="goods.val" value="" />
	<s:textfield name="goods.duration" label="当期（月）"
		value="%{goods.duration}" />
	<s:textfield name="goods.accessory" value="" label="规格和装况" />
	<s:textarea name="goods.memo1" label="备注" rows="3"
		cssStyle="width:400px" value="">
	</s:textarea>
	<s:submit label="物品添加完成" name="afterAddGoods" value="物品添加完成" />
	<s:submit label="继续添加物品" name="afterAddGoods" value="继续添加物品" />

</s:form>
<h5>目前仅支持添加最多三件同手续费率的物品</h5>
</fieldset>
</body>
</html>
