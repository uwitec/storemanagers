<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎登录</title>
		<link rel="stylesheet" type="text/css" href="../css/default.css">
		<link rel="stylesheet" type="text/css" href="../js/easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css" />
		<script type="text/javascript" src="../js/easyui/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>	
		<script type="text/javascript" src="dic.js"></script>
		<script type="text/javascript">
		$(function(){
			$("#tt").datagrid({
				height:$("#body").height()-$('#search_area').height()-5,
				width:$("#body").width(),
				idField:'user_no',
				url:"userList.do",
				queryParams:{},
				singleSelect:true, 
				nowrap:true,
				pageSize:10,
				fitColumns:true,
				rownumbers:true,
				showPageList:false,
				columns:[[
					{field:'user_no',title:'用户号码',width:100,halign:"center", align:"left"},
					{field:'user_name',title:'姓名',width:100,halign:"center", align:"left"},
					{field:'dep_no',title:'部门',width:100,halign:"center", align:"left"},
					{field:'role_no',title:'角色',width:100,halign:"center", align:"left"},
					{field:'user_sts',title:'状态',width:100,halign:"center", align:"left",
						formatter:function(val,rec){
							return dic_userSts(val);
						}
					}
				]],
				toolbar:'#tt_btn',
        		pagination:true,
				onDblClickRow:function(rowIndex, rowData){
					viewDetail(rowIndex,rowData.user_no);
				}
			});
			
			//新增弹出框
			$("#save").on("click", function(){
				$("#self_win").window({
					width:620,
					height:350,
					href:'userAdd.jsp',
					title:'新增用户'
				});
			});
	
			//修改
			$("#update").on("click", function(){
				var row = $("#tt").datagrid('getSelected');
				if(row){
					var index = $("#tt").datagrid('getRowIndex', row);
					var user_no = row.user_no;					
					$("#self_win").window({
						width:620,
						height:350,
						href:'userDetail.do?method=getUser&user_no='+user_no,
						title:'修改用户'
					});
				}else{
					$parent.messager.alert("提示","请选择要修改的记录", "info");
				}
			});
			
			//删除
			$("#delete").on("click", function(){
				var row = $("#tt").datagrid('getSelected');
				if(row){
					var index = $("#tt").datagrid('getRowIndex', row);
					var user_no = row.user_no;					
					$parent.messager.confirm("提示","确定删除[" + row.user_no +"]吗？", function(r){
						if(r){
							doAjax("userDel.do",{user_no:user_no,method:"delUser"});
							$("#tt").datagrid('deleteRow', index); 
						}
					});
				}
			});
		});
		
		function viewDetail(date, id){
			$("#self_win").window({
					width:620,
					height:350,
					href:'userDetail.do?method=getUser&user_no='+id,
					title:'修改用户'
			});
		}

		//监听窗口大小变化
		window.onresize = function(){
			setTimeout(domresize,300);
		};
		//改变表格宽高
		function domresize(){
			$('#tt').datagrid('resize',{  
				height:$("#body").height()-$('#search_area').height()-5,
				width:$("#body").width()
			});
		}
		
		function searchData(){
			var name = $('#userName').val();
			var no = $('#depNo').val();
			$('#tt').datagrid({url:'userList.do',queryParams:{user_name:name,dep_no:no} });
		}
		</script>
	</head>
	
	<body class="easyui-layout">
	<div id="body" region="center" > 
  	<!-- 查询条件区域 -->
  	<div id="search_area" >
    	<div id="conditon">
      		<table border="0">
        	<tr>
          		<td>用户名：</td>
          		<td ><input id="userName"  value=""/></td>
          		<td>&nbsp;部门：</td>
          		<td><input id="depNo"  value=""/></td>
          		<td>
              		<a  href="javascript:searchData()" class="easyui-linkbutton my-search-button" iconCls="icon-search" plain="true">查询</a> 
          		</td>
        	</tr>
      		</table>
    	</div>
    	<span id="openOrClose"></span> 
  	</div>
  	
  	<!-- 数据表格区域 -->
  	<table id="tt" style="table-layout:fixed;" ></table>
  	
  	<!-- 表格顶部工具按钮 -->
  	<div id="tt_btn">
      	<a href="javascript:void(0)"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      	<a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
      	<a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
   	</div>
	</div>
	<div id="self_win"></div>
	</body>
</html>