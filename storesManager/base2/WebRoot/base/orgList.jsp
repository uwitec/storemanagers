<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String contextPath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/css/default.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/js/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/js/easyui/themes/icon.css" />
<script type="text/javascript"
	src="<%=contextPath%>/js/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/common.js"></script>
<script type="text/javascript">
function convert(rows){
    function exists(rows, parentId){
        for(var i=0; i<rows.length; i++){
            if (rows[i].id == parentId) return true;
        }
        return false;
    }
    
    var nodes = [];
    // get the top level nodes
    for(var i=0; i<rows.length; i++){
        var row = rows[i];
        if (!exists(rows, row.parentId)){
            nodes.push({
                id:row.id,
                text:row.name
            });
        }
    }
    
    var toDo = [];
    for(var i=0; i<nodes.length; i++){
        toDo.push(nodes[i]);
    }
    while(toDo.length){
        var node = toDo.shift();    // the parent node
        // get the children nodes
        for(var i=0; i<rows.length; i++){
            var row = rows[i];
            if (row.parentId == node.id){
                var child = {id:row.id,text:row.name};
                if (node.children){
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}
$(function(){
$('#tt').tree({
    url: '<%=contextPath%>/orgList.do',
			loadFilter : function(rows) {
				return convert(rows);
			}
		});
		
	
//新增弹出框
$("#save").on("click", function(){
	var node = $('#tt').tree('getSelected');
	if(node){
		var id=node.id;
		$("#self_win").window({
			width:300,
			height:300,
			href:'<%=contextPath%>/base/orgAdd.jsp?id='+id,
			title:'新增机构'
		});
	}else{
		$parent.messager.alert("提示","请选择一个机构", "info");
	}
});

//修改
$("#update").on("click", function(){
	var node = $('#tt').tree('getSelected');
	if(node){
		$("#self_win").window({
			width:620,
			height:350,
			href:'<%=contextPath%>/orgDetail.do?id='+id,
			title:'修改机构'
		});
	}else{
		$parent.messager.alert("提示","请选择要修改的记录", "info");
	}
});
	})
</script>
<body class="easyui-layout">
   	<div style="padding:3px 2px;border-bottom:1px solid #ccc"></div>
	<div id="tt_btn">
      	<a href="javascript:void(0)"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      	<a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
      	<a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
   	</div>
   	<div style="padding:3px 2px;border-bottom:1px solid #ccc"></div>
   	
	<ul id="tt" class="easyui-tree"></ul>
<div id="self_win"></div>
</body>
</html>