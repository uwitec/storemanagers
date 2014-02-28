<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<script>
		$(function(){
			$("#addUser_cancel").on("click", function(){
				$("#self_win").window("close");
			});
			
			$("#addUser_save").on("click", function(){
				$("#baseForm").submit();
			});
		})
		</script>
	<form action="userAdd.do" id="baseForm" method="post">
	<input type="hidden" name='method' value="addUser">
	<div class="content" align="center">
		<p> 用户新增</p><br>
	    <table width="600" border="0" align="center" cellpadding="3">
	      <tr>
	      	<td width="20%" align="right"><label for="user_no"><span class="x">*</span>用户号码：</label></td>
	        <td width="30%" align="left"> <input type="text" name="user_no" id="user_no" maxLength="6" size="10"/></td>        
	        <td width="20%" align="right"><label for="user_name"><span class="x">*</span>用户名：</label></td>
	        <td width="30%" align="left"><input type="text" name="user_name" id="user_name" maxLength="20" size="20"/></td>
	      </tr>
	      <tr>
	      	<td width="20%" align="right"><label for="org_no"><span class="x">*</span>机构：</label></td>
	        <td width="30%"> <input type="text" name="org_no" id="org_no" maxLength="6" size="15"/></td>        
	        <td width="20%" align="right"><label for="dep_no"><span class="x">*</span>部门：</label></td>
	        <td width="30%"> <input type="text" name="dep_no" id="dep_no" maxLength="20" size="15"/></td>
	      </tr>
	      <tr>
	      	<td width="20%" align="right"><label for="role_no"><span class="x">*</span>角色：</label></td>
	        <td width="30%"> <input type="text" name="role_no" id="role_no" maxLength="6" size="15"/></td>        
	        <td width="20%" align="right"><label for="user_sts"><span class="x">*</span>状态：</label></td>
	        <td width="30%"> <input type="text" name="user_sts" id="user_sts" maxLength="20" size="15"/></td>
	      </tr>
	    </table>
	</div>
	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
	     <a id="addUser_save" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-save" href="javascript:void(0)" > 保存</a> 
	     <a id="addUser_cancel" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-cancel" href="javascript:void(0)" >取消</a>
	</div>
	</form>