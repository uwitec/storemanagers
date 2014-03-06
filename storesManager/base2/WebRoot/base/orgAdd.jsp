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
			        $.messager.alert('Info', data, 'info');
			    }
			});
		})
		</script>
	<form action="<%=contextPath %>/orgAdd.do" id="baseForm" method="post">
	<input type="hidden" name='method' value="addUser">
	<div class="content" align="center">
		<p> 部门新增</p><br>
	    <table width="300" border="0" align="center" cellpadding="3">
	      <tr>
	        <input type="hidden" name="org_upno" id="org_upno" value="<%=request.getParameter("id")%>"/>      
	        <td width="20%" align="right"><label for="org_no"><span class="x">*</span>部门名称：</label></td>
	        <td width="30%"> <input type="text" name="org_no" id="org_no" maxLength="20" size="15"/></td>
	        <td width="20%" align="right"><label for="org_lkman"><span class="x"></span>部门联系人：</label></td>
	        <td width="30%"> <input type="text" name="org_lkman" id="org_lkman" maxLength="50" size="15"/></td>
	        <td width="20%" align="right"><label for="org_tel"><span class="x"></span>联系人电话：</label></td>
	        <td width="30%"> <input type="text" name="org_tel" id="org_tel" maxLength="20" size="15"/></td>
	      </tr>
	    </table>
	</div>
	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
	     <a id="addUser_save" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-save" href="javascript:void(0)" > 保存</a> 
	     <a id="addUser_cancel" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-cancel" href="javascript:void(0)" >取消</a>
	</div>
	</form>