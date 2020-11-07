function btnQuery(pagePerRows) {
	queryForm.action = "user.do?action=sysUserIndex&curPage=1&pageRows="+ pagePerRows;
	queryForm.submit();
}
function funAdd() {
	art.dialog.open('user.do?action=sysUserAdd', {
		id : 'memdiv',
		width : 570,
		height : 260,
		title : '新增用户'
	});
}
function funEdit(curPage, pageRows) {
	var strChoseUserId=$('input:radio[name="usercheck"]:checked').val(); 
	if (strChoseUserId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
			art.dialog.data('curPage', curPage);
			art.dialog.data('pageRows', pageRows);
			art.dialog.data('userCode', strChoseUserId);
			art.dialog.open('user.do?action=sysUserEdit&userCode=' + strChoseUserId, {
				id : 'memdiv',
				width : 570,
				height : 260,
				title : '编辑用户'
			});
	}
}

function submitRegistForm() {
	$.ajax({
		type : "POST",
		data : $('#frmServRegist').serialize(),
		dataType : "json",
		url : "user.do?action=saveSysUser",
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '新增用户成功',
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
					content : '新增用户失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '新增用户失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}
function fundel(curPage, pageRows) {
	var strChoseUserId=$('input:radio[name="usercheck"]:checked').val(); 
	alert(strChoseUserId);
	if (strChoseUserId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		$.ajax({
			type : "POST",
			data : "userCode=" + strChoseUserId,
			dataType : "json",
			url : "user.do?action=deleteUser",
			success : function(result) {
				if (result.result == "succ") {
					// 刷新父页面
					var win = art.dialog.open.origin;
					win.location.reload();
					return false;
				} else {
					art.dialog({
						content : '删除用户失败',
						id : 'EF893L',
						title : '错误',
						icon : 'error'
					});
				}
			},
			error : function(result) {
				art.dialog({
					content : '删除用户失败',
					id : 'EF893L',
					title : '错误提示',
					icon : 'error'
				});
			}
		});
	}
}

//重置密码
function funResetUserPwd(curPage, pageRows){
	var strChoseUserId=$('input:radio[name="usercheck"]:checked').val();
//	var $chks=$('input:radio[name="usercheck"]:checked');
//	var uuid= $chks.attr("data-uuid");
	if (strChoseUserId == null) {
		tipAlert('warning','提示','请选择一笔记录!');
	} else {
		art.dialog({
			content : "<span style='font-size:12px;'>真要修改密码吗</span>",
			ok : function() {
//				document.location.href = "/wharf/portal.do?action=modifyUsrPwd&uuId="+uuid + "&curPage="+curPage+"&pageRows="+pageRows;
				$.ajax({
					type : "POST",
					data : "userCode=" + strChoseUserId,
					dataType : "json",
					url : "user.do?action=resetUserPwd",
					success : function(result) {
						if (result.result == "succ") {
							tipAlert('succeed','提示','重置成功!');
						} else {
							tipAlert('error','提示','重置失败!');
						}
					},
					error : function(result) {
						tipAlert('error','提示','ajax重置失败!');
					}
				});
			},
			cancelVal : '关闭',
			cancel : true,
			icon:'question',
			title:"询问"
		});
	}
}

function funEditUser(){
	$.ajax({
		type : "POST",
		data :  $('#frmServRegist').serialize(),
		dataType : "json",
		url :"user.do?action=editSaveUser",
		success : function(result) {
  			if(result.result=="succ"){
  				art.dialog({
				    content: '编辑用户成功',
				    id: 'EF893L',
				    title: '成功',
				    icon: 'succeed'
				});
  			    //刷新父页面
  				var win = art.dialog.open.origin;
  				win.location.reload();
  				return false;
  			}else{
  				art.dialog({
				    content: '编辑用户失败',
				    id: 'EF893L',
				    title: '错误',
				    icon: 'error'
				});
  			}       	  			
		},
		error : function(result) {
			art.dialog({
			    content: '编辑用户失败',
			    id: 'EF893L',
			    title: '错误提示',
			    icon: 'error'
			});
		}
});	
}


function selAll(obj) {
	if (obj.checked) {
		$("[name='rolecheck']").prop("checked", 'true');
	} else {
		$("[name='rolecheck']").removeAttr("checked");
	}
}
//分配用户角色
function funRole(curPage, pageRows){
	var strChoseUserId=$('input:radio[name="usercheck"]:checked').val(); 
	if (strChoseUserId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		art.dialog.open('sysRole.do?action=sysRoleList&userCode=' + strChoseUserId, {
			id : 'memdiv',
			width : 570,
			height : 260,
			title : '分配用户角色'
		});
	}
}
//分配用户角色
function grantUserRole(){
	var userCode=$("#userCode").val();
	var roleIds = "";
	$("input[name='rolecheck']:checked").each(function() {
		roleIds += $(this).val() + ",";
	});
	if (roleIds == "") {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		$.ajax({
			type: "POST",
			url: "/SpringMVCMybatisDemo/user.do?action=grantUserRoles",	
			data:"userCode="+userCode+"&roleIds="+roleIds,
			dataType: "json",
			cache: true,
			success:function(result){
				if(result.result=="succ"){
					var win = art.dialog.open.origin;
	  				win.location.reload();
	  				return false;
				}else{
					art.dialog({
	    			    content: "<span style='font-size:12px'>分配用户角色失败</span>",			   
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
}