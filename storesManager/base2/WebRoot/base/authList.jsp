<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
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
        	var isCheck=false;
        	if(row.checked=='true'){
        		isCheck=true;
        	}
            nodes.push({
                id:row.id,
                text:row.name,
                checked:isCheck
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
            	var isCheck=false;
            	if(row.checked=='true'){
            		isCheck=true;
            	}
                var child = {id:row.id,text:row.name,checked:isCheck};
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
$('#tt2').tree({
    url: '<%=contextPath%>/roleAuthList.do',
			loadFilter : function(rows) {
				return convert(rows);
			}
		});
		
//修改
$("#update").on("click", function(){
	var nodes = $('#tt2').tree('getChecked');
	if(nodes.length!=0){
		var s = '';
        for (var i = 0; i < nodes.length; i++) {
            if (s != '') 
                s += ',';
            s += nodes[i].id;
        }
        
        doAjax("<%=contextPath%>/roleAuthUpdate.do",{json:s,method:"roleAuthUpdate"});
	
	}else{
		$parent.messager.alert("提示","请选择菜单！", "info");
	} 
});

$("#exit").on("click", function(){
	$("#self_win").window("close");
});

});
</script>
   	 <div style="margin:1px 0;"></div>
    <div style="padding:0px;border:0px solid #ddd;width: 150px;height: 20px">
        <a href="#" class="easyui-linkbutton" id="update" data-options="plain:true,iconCls:'icon-save'">保存</a>
        <a href="#" class="easyui-linkbutton" id="exit" data-options="plain:true,iconCls:'icon-close'">关闭</a>
    </div>
 <div style="padding:3px 2px;border-bottom:1px solid #ccc"></div>
	<ul id="tt2" class="easyui-tree" checkbox="true"></ul>
