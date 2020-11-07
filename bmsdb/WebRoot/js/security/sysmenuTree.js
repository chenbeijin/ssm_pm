var setting = {
	view : {
		selectedMulti : false
	},
	check : {
		enable : true
	},
	data : {
		simpleData : {
			enable : true
		}
	}
};

$(document).ready(function() {	
	clearFlag = $("#last").attr("checked");
	var roleId=$("#roleId").val();
	//----------------------------------------------------------------------
	$.ajax({
		type: "POST",
		url: "/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuTreeData",				
		dataType: "json",
		data:"roleId="+roleId,
		cache: true,
		success:function(result){
			if(result.result=="succ"){
				var zNodes=result.resultlist;
				$.fn.zTree.init($("#treeMenu"), setting, zNodes);
			}else{
				art.dialog({
    			    content: "<span style='font-size:12px'>系统菜单初始化失败</span>",			   
    			    title:"错误",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
			}			
		},
		error: function(result){
     		if(result.status==200){
     			art.dialog({
    			    content: "<span style='font-size:12px'>"+result.responseText+"</span>",			   
    			    title:"错误信息",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
     		}else{
     			art.dialog({
    			    content: "<span style='font-size:12px'>系统菜单初始化失败</span>",			   
    			    title:"错误信息",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
     		}
		}
	});	
	//---------------------------------------------------------------------------
});
