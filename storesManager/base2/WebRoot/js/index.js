/*
	主页加载方法
	@eric
*/
//系统时间显示
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		selectedMulti: false
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("menuTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				addTabs(node.name, node.file);
			}
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"系统管理", open:true},
	{ id:10, pId:1, name:"机构管理", file:"base/orgList.jsp"},
	{ id:11, pId:1, name:"用户管理", file:"base/userList.jsp"},
	{ id:12, pId:1, name:"权限管理", file:"base/authList.jsp"},
	{ id:2, pId:0, name:"医考管理", open:true},
	{ id:21, pId:2, name:"医考试题", file:"eoms/examList.jsp"},
	{ id:3, pId:0, name:"学员管理", open:true},
	{ id:31, pId:3, name:"学员管理", file:"eoms/studentList.jsp"},
	{ id:4, pId:0, name:"移动应用", open:true},
	{ id:40, pId:4, name:"应用设置", file:"eoms/appList.jsp"},
	{ id:41, pId:4, name:"发布首页", file:"eoms/appList.jsp"},
	{ id:42, pId:4, name:"发布广告", file:"eoms/appList.jsp"},
	{ id:43, pId:4, name:"发布信息", file:"eoms/appList.jsp"}
];

$(function() {
	$.fn.zTree.init($("#menuTree"), setting, zNodes);
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
	
	//中间部分tab
	$('#tabs').tabs({  
		border:false,
		fit:true,
		onSelect: function(title, index){
			var treeNode = zTree.getNodeByParam("name", title, null);
			zTree.selectNode(treeNode);
		}
	}); 
	
	$('.index_panel').panel({  
	  width:300,  
	  height:200,  
	  closable:true,
	  minimizable:true,
	  title: 'My Panel'
	});
	
});

//添加一个选项卡面板 
function addTabs(title, url, icon){
	if(!$('#tabs').tabs('exists', title)){
		$('#tabs').tabs('add',{  
			title:title,  
			content:'<iframe src="'+url+'" frameBorder="0" border="0" scrolling="no" style="width: 100%; height: 100%;"/>',
			closable:true
		});
	} else {
		$('#tabs').tabs('select', title);
	}
}