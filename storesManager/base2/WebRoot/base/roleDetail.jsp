<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<% String contextPath=request.getContextPath(); %>
			<script type="text/javascript" src="<%=contextPath%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script>
		$(function(){
			$("#addRole_cancel").on("click", function(){
				$("#self_win").window("close");
			});
			
			$("#addRole_save").on("click", function(){
				$("#baseForm").submit();
			});
			
			$('#baseForm').form({
			    success:function(data){
			    	if(data=='1'){
				    	$.messager.alert('Info', "成功", 'info');
						$("#self_win").window("close");
				    	$('#tt').datagrid('reload');
			    	}else{
			    		$.messager.alert('Info', "失败", 'info');
			    	}
			    }
			});
		})
		</script>
	<form action="<%=contextPath %>/roleUpdate.do" id="baseForm" method="post">
		<div class="content" align="center">
	
            <table>
                <tr>
                    <td>角色名称:</td>
                    <td>
                    <input type="hidden" name="role_no" value="${command.role_no}">
                    <input class="easyui-validatebox" type="text" name="role_name" data-options="required:true" value="${command.role_name }"></input></td>
                </tr>
            </table>
        </div>
        </form>
     	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
	     <a id="addRole_save" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-save" href="javascript:void(0)" > 保存</a> 
	     <a id="addRole_cancel" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-cancel" href="javascript:void(0)" >取消</a>
	</div>
