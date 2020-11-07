//多条件查询角色
function btnQuery(pagePerRows) {
	queryForm.action = "/SpringMVCMybatisDemo/sysRole.do?action=findByMutilSysRole&curPage=1&pageRows="+ pagePerRows;
	queryForm.submit();
}
//添加角色
function funAdd() {
	art.dialog.open('/SpringMVCMybatisDemo/sysRole.do?action=sysRoleAddIndex', {
		id : 'memdiv',
		width : 400,
		height : 200,
		title : '新增角色'
	});
}
//编辑角色
function funEdit(curPage, pageRows) {
	var strChoseRoleId=$('input:radio[name="rolecheck"]:checked').val(); 
	if (strChoseRoleId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
			art.dialog.data('curPage', curPage);
			art.dialog.data('pageRows', pageRows);
			art.dialog.data('roleId', strChoseRoleId);
			art.dialog.open('/SpringMVCMybatisDemo/sysRole.do?action=sysRoleEditIndex&roleId=' + strChoseRoleId, {
				id : 'memdiv',
				width : 400,
				height : 200,
				title : '编辑角色'
			});
	}
}
//保存角色
function submitRegistForm() {
	$.ajax({
		type : "POST",
		data : $('#frmServRegist').serialize(),
		dataType : "json",
		url : "/SpringMVCMybatisDemo/sysRole.do?action=sysRoleSave",
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '新增角色成功',
					id : 'EF893L',
					title : '成功',
					icon : 'succeed'
				});
				// 刷新父页面
				var win = art.dialog.open.origin;
				win.location.reload();
				return false;
			} else {
				art.dialog({
					content : '新增角色失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '新增角色失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}
//编辑角色
function funRoleEdit() {
	var url = "/SpringMVCMybatisDemo/sysRole.do?action=sysRoleEdit";
	$.ajax({
		type : "POST",
		data : $('#frmServRegist').serialize(),
		dataType : "json",
		url : url,
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '编辑角色成功',
					id : 'EF893L',
					title : '成功',
					icon : 'succeed'
				});
				//刷新父页面
				var win = art.dialog.open.origin;
				win.location.reload();
				return false;
			} else {
				art.dialog({
					content : '编辑角色失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '编辑角色失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}
//删除角色
function fundel(curPage, pageRows) {
	var strChoseRoleId=$('input:radio[name="rolecheck"]:checked').val(); 
	if (strChoseRoleId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		$.ajax({
			type : "POST",
			data : "roleId=" + strChoseRoleId,
			dataType : "json",
			url : "/SpringMVCMybatisDemo/sysRole.do?action=deleteSysRole",
			success : function(result) {
				if (result.result == "succ") {
					// 刷新父页面
					var win = art.dialog.open.origin;
					win.location.reload();
					return false;
				} else {
					art.dialog({
						content : '删除角色失败',
						id : 'EF893L',
						title : '错误',
						icon : 'error'
					});
				}
			},
			error : function(result) {
				art.dialog({
					content : '删除角色失败',
					id : 'EF893L',
					title : '错误提示',
					icon : 'error'
				});
			}
		});
	}
}
//分配菜单
function funMenu(curPage, pageRows) {
	var strChoseRoleId=$('input:radio[name="rolecheck"]:checked').val();
	if (strChoseRoleId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {	
		art.dialog.data('curPage', curPage);
		art.dialog.data('pageRows', pageRows);
		art.dialog.data('roleId', strChoseRoleId);
		art.dialog.open('/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuTree&roleId=' + strChoseRoleId, {
			id : 'memdiv',
			width : 260,
			height : 440,
			title : '分配角色菜单'
		});
	}
}
//分配菜单
function btnGrant(){	
	var menuIds="";
	var zTree = $.fn.zTree.getZTreeObj("treeMenu"), 
	nodes = zTree.getCheckedNodes();
	for ( var i = 0, l = nodes.length; i < l; i++) {
		menuIds+=nodes[i].id+",";		
	}	
	menuIds = menuIds.substring(0, menuIds.length - 1);
	$.ajax({
		type: "POST",
		url: "/SpringMVCMybatisDemo/sysRole.do?action=grantRoleMenus",	
		data:"roleId="+roleId+"&menuIds="+menuIds,
		dataType: "json",
		cache: true,
		success:function(result){
			if(result.result=="succ"){
				var win = art.dialog.open.origin;
  				win.location.reload();
  				return false;
			}else{
				art.dialog({
    			    content: "<span style='font-size:12px'>分配角色菜单失败</span>",			   
    			    title:"错误",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
			}			
		},
		error: function(result){
     		art.dialog({
    			content: "<span style='font-size:12px'>"+result.responseText+"</span>",			   
    			title:"错误信息",
    			cancelVal: '关闭',
    			icon: 'error'
    		});
		}
	});	
}