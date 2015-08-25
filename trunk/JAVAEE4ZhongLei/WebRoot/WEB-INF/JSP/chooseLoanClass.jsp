<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择典当物品的类别 众磊典当系统</title>
</head>
<body>
<fieldset style="height: 500px; width: 700px; padding: 20px"><legend>Choose--LoanClass</legend>
<table width="693" height="477" border="0">
	<tr>
		<td width="84">&nbsp;</td>
		<td width="507"><s:set name="bs"
			value="#{'金饰品':{'金项链','金戒指','金耳环','金  镯','金手链','金挂件','铂金戒指','铂金项链','铂金手链','铂金手镯','铂金耳环','铂金挂件','金饰品（见备注）','金项链带坠','铂金项链带坠','金耳环带坠','金料','铂金耳钉','金耳钉'},'K金饰品':{'18K项链','18K戒指','18K手链','18K挂件','18K项链挂件','18K白金钻石戒指','18K钻石戒指'},'钻饰品':{'铂金钻戒','铂金钻项链','铂金钻手链','铂金钻手镯','铂金钻耳钉','铂金钻挂件','黄金钻戒','黄金钻项链','黄金钻手链','黄金钻手镯','黄金钻耳环','黄金钻挂件'},'珠宝饰品':{'蓝宝戒指','蓝宝项链','蓝宝手镯链','蓝宝耳环','蓝宝挂件','红宝戒指','红宝项链','红宝手镯链','红宝耳环','红宝挂件','镶石铂金戒指','镶石铂金项链','镶石铂金手镯链','镶石铂金耳环','镶翠挂件','镶石戒指','镶石项链','镶石耳环','镶石挂件'},'房产':{'别墅','公寓','高层','多层','底商','商住两项','房屋'},'有价证券':{'国库券','债券'},'五交类（音响器材类）':{'手机','电脑','照相机','电视机','手表','音响','摄像机'},'机动车':{'轿车','小型轿车','摩托车','挖掘机'},'服装类':{'服装'}, '其他类':{'其他','杂项(见备注）','电器一批'}}" />
		<s:form action="addGoodsInfo">
			<s:doubleselect label="选择货品的类别" size="10" name="loan_class"
				list="#bs.keySet()" doubleList="#bs[top]" doubleName="loan_name"
				doubleSize="20" />
			<s:submit />
		</s:form></td>
		<td width="88">&nbsp;</td>
	</tr>
</table>
</fieldset>
</body>
</html>
