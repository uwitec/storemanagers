<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>库存管理系统</title>
		<link rel="stylesheet" type="text/css" href="./css/default.css">
		<link rel="stylesheet" type="text/css" href="./js/easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="./js/easyui/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="./js/zTree/css/zTreeStyle/zTreeStyle.css">
		<script type="text/javascript" src="./js/easyui/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="./js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="./js/zTree/jquery.ztree.all-3.5.min.js"></script>
		<script type="text/javascript" src="./js/index.js"></script>
		<script type="text/javascript" src="./js/extends.js"></script>
		<script type="text/javascript" src="./js/common.js"></script>		
	</head>
	<body class="easyui-layout">
		<!-- 头部标题 -->
		<div data-options="region:'north',border:false" style="height:60px; padding:5px; background:#F3F3F3"> 
			<span class="northTitle">库存管理系统</span>
    		<span class="loginInfo">登录用户：admin&nbsp;&nbsp;姓名：管理员&nbsp;&nbsp;角色：系统管理员</span>
		</div>

		<!-- 左侧导航 -->
		<div data-options="region:'west',split:true,title:'导航菜单', fit:false" style="width:200px;"> 
  			<ul id="menuTree" class="ztree"> </ul>
		</div>

		<!-- 页脚信息 -->
		<div data-options="region:'south',border:false" style="height:20px; background:#F3F3F3; padding:2px; vertical-align:middle;">
			<span id="sysVersion">系统版本：V1.0</span>
		    <span id="nowTime"></span>
		</div>
		
		<div id="center" data-options="region:'center'">
  			<div id="tabs" class="easyui-tabs">
    			<div title="首页" style="padding:5px;display:block;" >
			      <p>模板说明：</p>
			        <ul>
			          <li>主界面使用 easyui1.3.5</li>
			          <li>导航树使用 JQuery-zTree-v3.5.15</li>
			        </ul>
			      <p>特性说明：</p>
			        <ul>
			          <li>所有弹出框均显示在顶级父窗口</li>
			          <li>修改easyui window拖动，移动时显示窗口而不显示虚线框，并限制拖动范围</li>
			        </ul>
    			</div>
  			</div>
		</div>

		<!-- 用于弹出框 -->
		<div id="parent_win"></div>
	</body>
</html>