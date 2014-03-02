<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

		<script>
		$(function(){
			$("#addUser_cancel").on("click", function(){
				$("#self_win").window("close");
			});
			
			$("#addUser_save").on("click", function(){
				$("#UserForm").submit();
			});
		})
		</script>
	<form:form action="../userUpdate.do" method="post" id="UserForm">
	<input type="hidden" name='method' value="updateUser">
	<div class="content" align="center">
		<p> 用户新增</p><br>
	    <table width="600" border="0" align="center" cellpadding="3">
	      <tr>
	      	<td width="20%" align="right"><label for="user_no"><span class="x">*</span>用户号码：</label></td>
	        <td width="30%" align="left">
	        <form:input path="user_no"/></td>        
	        <td width="20%" align="right"><label for="user_name"><span class="x">*</span>用户名：</label></td>
	        <td width="30%" align="left"><form:input path="user_name"/></td>
	      </tr>
	      <tr>
	      	<td width="20%" align="right"><label for="org_no"><span class="x">*</span>机构：</label></td>
	        <td width="30%"><form:input path="org_no"/></td>        
	        <td width="20%" align="right"><label for="dep_no"><span class="x">*</span>部门：</label></td>
	        <td width="30%"><form:input path="dep_no"/> </td>
	      </tr>
	      <tr>
	      	<td width="20%" align="right"><label for="role_no"><span class="x">*</span>角色：</label></td>
	        <td width="30%"><form:input path="role_no"/></td>        
	        <td width="20%" align="right"> <label for="user_sts"><span class="x">*</span>状态：</label></td>
	        <td width="30%"> <form:input path="user_sts"/></td>
	      </tr>
	    </table>
	</div>
	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
	     <a id="addUser_save" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-save" href="javascript:void(0)" > 保存</a> 
	     <a id="addUser_cancel" class="easyui-linkbutton my-dialog-button" plain="true" icon="icon-cancel" href="javascript:void(0)" >取消</a>
	</div>
	</form:form>