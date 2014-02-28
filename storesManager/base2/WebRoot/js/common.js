
/*
	公共方法文件
	@eric
*/
var $parent = self.parent.$;
$(function () {
	//隐藏显示查询条件区域
	$("#openOrClose").on("click", function () {
		$("#conditon").toggle(80);
		setTimeout(domresize, 100);//条件隐藏，改变表格高度
	});
});


function doAjax(url, param) {
	$.ajax({
		type:"post", 
		url:url,
		data:param,
		success:function (data) {
			$parent.messager.alert("提示","操作成功！", "info");
		}, 
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			$parent.messager.alert("提示","操作失败："+errorThrown, "info");
		}
	});
}

