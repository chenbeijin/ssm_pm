//多条件查询
function btnQuery(pagePerRows) {
	queryForm.action = "/SpringMVCMybatisDemo/sysMenu.do?action=findByMutilSysMenu&curPage=1&pageRows="+ pagePerRows;
	queryForm.submit();
}
//新增菜单
function funAdd() {
	art.dialog.open('/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuAddIndex', {
		id : 'memdiv',
		width : 400,
		height : 260,
		title : '新增菜单'
	});
}
//编辑菜单
function funEdit(curPage, pageRows) {
	var strChoseMenuId=$('input:radio[name="menucheck"]:checked').val(); 
	if (strChoseMenuId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
			art.dialog.data('curPage', curPage);
			art.dialog.data('pageRows', pageRows);
			art.dialog.data('menuId', strChoseMenuId);
			art.dialog.open('/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuEditIndex&menuId=' + strChoseMenuId, {
				id : 'memdiv',
				width : 400,
				height : 260,
				title : '编辑菜单'
			});
	}
}
//编辑菜单
function funMenuEdit() {
	$.ajax({
		type : "POST",
		data : $('#frmMenu').serialize(),
		dataType : "json",
		url : "/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuEdit",
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '编辑菜单成功',
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
					content : '编辑菜单失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '编辑菜单失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}
//保存菜单
function funMenuSave() {
	$.ajax({
		type : "POST",
		data : $('#frmMenu').serialize(), 
		dataType : "json",
		url : "/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuSave",
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '新增菜单成功',
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
					content : '新增菜单失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '新增菜单失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}
//初始化菜单等级
function initGrade(obj){
	var menuName=$("#menuParentId option:selected").text();	
	var menuGrade=menuName.substring(1,menuName.indexOf("]"));
	$('input[name=menuGrade]').val(parseInt(menuGrade)+1); 
}
