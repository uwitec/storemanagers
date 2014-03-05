<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% String contextPath=request.getContextPath();%>
<script>
	$(function() {
		$("#addUser_cancel").on("click", function() {
			$("#self_win").window("close");
		});

		$("#addUser_save").on("click", function() {
			var flag=$("#UserForm").form('validate');  
			if(flag)
			$("#UserForm").submit();
		});
	})
</script>
<form action="<%=contextPath %>/userUpdate.do" method="post" id="UserForm">
	<input type="hidden" name='method' value="updateUser">
	<div class="content" align="center">
		<p>用户新增</p>
		<br>
		<table width="600" border="0" align="center" cellpadding="3">
			<tr>
				<td width="20%" align="right"><span class="x">*</span>用户号码：</td>
				<td width="30%" align="left"><input name="user_no" value="${command.user_no }"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
				</td>
				<td width="20%" align="right"><span class="x">*</span>用户名：</td>
				<td width="30%" align="left"><input name="user_name" value="${command.user_name }"
					class="easyui-validatebox" required="true" missingMessage="不能为空">

				</td>
			</tr>
			<tr>
				<td width="20%" align="right"><span class="x">*</span>机构：</td>
				<td width="30%"><input name="org_no" class="easyui-validatebox"  value="${command.org_no }"
					required="true" missingMessage="不能为空"></td>
				<td width="20%" align="right"><span class="x">*</span>部门：</td>
				<td width="30%"><input name="dep_no" class="easyui-validatebox"  value="${command.dep_no }"
					required="true" missingMessage="不能为空"></td>
			</tr>
			<tr>
				<td width="20%" align="right"><span class="x">*</span>角色：</td>
				<td width="30%"><input name="role_no"  value="${command.role_no }"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
				</td>
				<td width="20%" align="right"><span class="x">*</span>状态：</td>
				<td width="30%"><input name=user_sts class="easyui-validatebox"  value="${command.user_sts }"
					required="true" missingMessage="不能为空"></td>
			</tr>
		</table>
	</div>
	<!-- 弹出框按钮 -->
	<div class="windowButton" align="center">
		<a id="addUser_save" class="easyui-linkbutton my-dialog-button"
			plain="true" icon="icon-save" href="javascript:void(0)"> 保存</a> <a
			id="addUser_cancel" class="easyui-linkbutton my-dialog-button"
			plain="true" icon="icon-cancel" href="javascript:void(0)">取消</a>
	</div>
</form>