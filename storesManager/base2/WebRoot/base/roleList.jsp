<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<% String contextPath=request.getContextPath(); %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色管理</title>
		<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/default.css">
		<link rel="stylesheet" type="text/css" href="<%=contextPath%>/js/easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=contextPath%>/js/easyui/themes/icon.css" />
		<script type="text/javascript" src="<%=contextPath%>/js/easyui/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/common.js"></script>	
		<script type="text/javascript" src="<%=contextPath%>/js/dic.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		
		<script type="text/javascript">
		$(function(){
			$("#tt").datagrid({
				height:$("#body").height()-$('#search_area').height()-5,
				width:$("#body").width(),
				idField:'role_no',
				url:"<%=contextPath%>/roleList.do",
				queryParams:{},
				singleSelect:true, 
				nowrap:true,
				pageSize:10,
				fitColumns:true,
				rownumbers:true,
				showPageList:true,
				columns:[[
					{field:'role_no',title:'角色编码',width:100,halign:"center", align:"left"},
					{field:'role_name',title:'角色名称',width:100,halign:"center", align:"left"},
					{field:'role_sts',title:'状态',width:100,halign:"center", align:"left",
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
					width:300,
					height:250,
					href:'roleAdd.jsp',
					title:'新增角色'
				});
			});
	
			//修改
			$("#update").on("click", function(){
				var row = $("#tt").datagrid('getSelected');
				if(row){
					var index = $("#tt").datagrid('getRowIndex', row);
					var role_no = row.role_no;					
					$("#self_win").window({
						width:300,
						height:250,
						href:'<%=contextPath%>/roleDetail.do?role_no='+role_no,
						title:'修改角色'
					});
				}else{
					$parent.messager.alert("提示","请选择要修改的角色", "info");
				}
			});
	
			//修改
			$("#auth").on("click", function(){
				var row = $("#tt").datagrid('getSelected');
				if(row){
					var index = $("#tt").datagrid('getRowIndex', row);
					var role_no = row.role_no;					
					$("#self_win").window({
						width:300,
						height:450,
						href:'<%=contextPath%>/base/authList.jsp',
						title:'设置权限'
					});
				}else{
					$parent.messager.alert("提示","请选择要设置权限的角色", "info");
				}
			});
			
			//删除
			$("#delete").on("click", function(){
				var row = $("#tt").datagrid('getSelected');
				if(row){
					var index = $("#tt").datagrid('getRowIndex', row);
					var role_no = row.role_no;					
					$parent.messager.confirm("提示","确定删除[" + row.role_name +"]吗？", function(r){
						if(r){
							doAjax("roleDel.do",{role_no:role_no,method:"delRole"});
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
					href:'<%=contextPath%>/roleDetail.do?role_no='+id,
					title:'修改角色'
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
			var name = $('#roleName').val();
		
			$('#tt').datagrid({url:'<%=contextPath%>/roleList.do',queryParams:{role_name:name} });
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
          		<td>角色名：</td>
          		<td ><input id="roleName"  value=""/></td>
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
      	<a href="javascript:void(0)"  id="auth" class="easyui-linkbutton" iconCls="icon-reset" plain="true">权限设置</a>
   	</div>
	</div>
	<div id="self_win"></div>
	</body>
</html>