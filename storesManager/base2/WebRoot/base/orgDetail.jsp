<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<% String contextPath=request.getContextPath(); %>

		<script>
		$(function(){
			$("#addUser_cancel").on("click", function(){
				$("#self_win").window("close");
			});
			
			$("#addUser_save").on("click", function(){
				$("#baseForm").submit();
			});
			
			$('#baseForm').form({
			    success:function(data){
			    	if(data=='1'){
				    	$.messager.alert('Info', "成功", 'info');
						$("#self_win").window("close");
				    	$('#tt').tree('reload');
			    	}else{
			    		$.messager.alert('Info', "失败", 'info');
			    	}
			    }
			});
		})
		</script>
<form action="<%=contextPath %>/orgUpdate.do" id="baseForm" method="post">
		<div class="content" align="center">
	
            <table>
                <tr>
                    <td>部门名称:</td>
                    <td>
                    	        <input type="hidden" name="org_upno" id="org_upno" value="${command.org_upno }"/>      
                    	        <input type="hidden" name="org_no" id="org_no" value="${command.org_no }"/>      
                    
                    <input class="easyui-validatebox" type="text" name="org_name" data-options="required:true" value="${command.org_name }"></input></td>
                </tr>
                <tr>
                    <td>部门联系人:</td>
                    <td><input class="easyui-validatebox" type="text" name="org_lkman" value="${command.org_lkman }"></input></td>
                </tr>
                <tr>
                    <td>联系人电话:</td>
                    <td><input class="easyui-validatebox" type="text" name="org_tel"  value="${command.org_tel }"></input></td>
                </tr>
            </table>
        </div>
        </form>
     	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
	     <a id="addUser_save" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-save" href="javascript:void(0)" > 保存</a> 
	     <a id="addUser_cancel" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-cancel" href="javascript:void(0)" >取消</a>
	</div>