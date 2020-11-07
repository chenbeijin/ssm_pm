//第一个文本得到焦点
function handleOnload() {
	$('input:text:first').focus();
}
// 回车切换焦点
document.onkeydown = function enterHandler(event) {
	var inputs = $("input"); // 可自行添加其它过滤条件
	var browser = navigator.appName; // 浏览器名称
	var userAgent = navigator.userAgent; // 取得浏览器的userAgent字符串
	var keycode = '';
	if (browser.indexOf('Internet') > -1) { // IE
		keycode = window.event.keyCode;
	} else if (userAgent.indexOf("Firefox") > -1) { // 火狐
		keycode = event.which;
	} else { // 其它
		keycode = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	}
	if (keycode == 13) // 可以自行加其它过滤条件
	{
		for ( var i = 0; i < inputs.length; i++) {
			if (inputs[i].id == document.activeElement.id) {
				i = i == (inputs.length - 1) ? -1 : i;
				if (inputs[i + 1].id == "sessionKey") {
					handleSubmit();
				}
				$('#' + inputs[i + 1].id).focus();
				break;
			}
		}
	}
}
// 登陆
function handleSubmit() {
	$.ajax({
		type : "POST",
		data : {
			usrName : $("#usrName").val(),
			usrPwd : $("#usrPwd").val(),
			usrRnd : $("#usrRnd").val()
		},
		dataType : "json",
		url : "/SpringMVCMybatisDemo/portal.do?action=validate",
		success : function(result) {
			if (result.result == "succ") {
			   document.location.href="/SpringMVCMybatisDemo/portal.do?action=index&sessionKey="+$("#sessionKey").val();
			} else {
				tipAlert('warning','提示',result.message);
			}
		},
		error : function(result) {
			tipAlert('error','提示',result);
		}
	});
}
function tipAlert(tipIcon,tiptitle,msg){
	art.dialog({
		content :"<span style='font-size:12px'>"+msg+"</span>",
		id : 'EF893L',
		title : tiptitle,
		time:2,
		icon : tipIcon
	});
}
//产生验证码
function checkRnd(obj){
  obj.src=obj.src+"&tm="+new Date();
}