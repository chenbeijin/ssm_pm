/************************************************
 * 公用js方法
 * @description require jQuery1.9.1,artDialog
 * @author lijie
 ************************************************/
/**
 * 数字精度处理
 * @param f 待处理数字
 * @param digit 容纳的小数位
 */
Math.formatFloat = function(f, digit) {
	return Math.round(f*Math.pow(10, digit))/Math.pow(10, digit); 
} 
/**
 * 清除表单元素值
 * @param formId 表单id
 * @description require jQuery
 */
function clearQryFrom(formId){
	$(':input','#'+qryForm)  
	 .not(':button, :submit, :reset')  
	 .val('')  
	 .removeAttr('checked')  
	 .removeAttr('selected');
}
/**
 * tab转换
 * @param name
 * @param cursel
 * @param n
 */
function setTab(name, cursel, n) {
	for ( var i = 1; i <= n; i++) {
		var tabLi = document.getElementById(name + i);
		var tabCur = document.getElementById(name + "_" + i);
		tabLi.className = i == cursel ? "hover2" : "hover1";
		tabCur.style.display = i == cursel ? "block" : "none";
	}
}
/**
 * 提示框
 * @param tipIcon
 * @param tiptitle
 * @param msg
 * @description require jQuery,artDialog
 */
function tipAlert(tipIcon,tiptitle,msg){
	art.dialog({
		content :"<span style='font-size:12px'>"+msg+"</span>",
		id : 'EF893L',
		title : tiptitle,
		icon : tipIcon
	});
}
/**
 * table全选
 * @param obj 全选框对象
 * @param chkName 子选框name
 * @description require jQuery1.9.1
 */
function selectAllChk(obj,chkName) {
	var chk = chkName || "uuid";
	if (obj.checked == true) {
		$("input[name='"+chk+"']").prop('checked', true);
	} else {
		$("input[name='"+chk+"']").prop('checked', false);
	}
}
/**
 * table行事件选中radio
 * @param obj
 * @param radioName
 */
function selRadioByTr(obj,radioName) {
	$(obj).find("input[name="+radioName+"]").prop("checked",true);
}
/**
 * table行事件选中checkbox(可由toolInit.js代替)
 * @param obj
 * @param radioName
 */
function selChkByTr(obj,chkName) {
	var $chk = $(obj).find("input[name="+chkName+"]");
	if($chk.prop("checked")){
		$chk.prop("checked",false);
	}else{
		$chk.prop("checked",true);
	}
}
/**
 * 刷新table行变色
 * @param tableId tableId
 * @description require jQuery
 */
function refreshTable(tableId){
	$("#"+tableId+" tbody tr").each(function(i,e){
		if(i%2==0){
			$(e).removeClass("tr1 tr2").addClass("tr1");
		}else{
			$(e).removeClass("tr1 tr2").addClass("tr2");
		}
		//绑定单击时间
		$(e).click(function(){
			$(this).addClass("hover").siblings().removeClass("hover");
		});
	});
}
/**
 * 删除table行
 * @param tableId tableId
 * @param chkName 子选框name
 * @description require jQuery 1.4.1
 */
function delTr(tableId,chkName){
	$("#"+tableId+" tbody tr").has("input[name='"+chkName+"']:checked").remove();
}

/**
 * 显示或隐藏table行明细
 * @param rowId
 */
function displayDetail(rowId) {
	var $detail = $("#detail"+rowId);
	if($detail.css("display")=="none"){
		$detail.css("display","");
	}else{
		$detail.css("display","none");
	}
//	if (eval("detail" + rowId).style.display == "") {
//		eval("detail" + rowId).style.display = "none";
//	} else {
//		eval("detail" + rowId).style.display = "";
//	}
}

//更换收缩图片
function changeImg(id){
	$obj = $("#"+id);
	$obj.toggleClass("toggleOpen");
	$obj.toggleClass("toggleClose");
}