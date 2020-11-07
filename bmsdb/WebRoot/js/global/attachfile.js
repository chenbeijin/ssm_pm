/**
 * 附件上传功能
 */
function uploadAttachFile(){
	  $("#frmfileupload").attr("action","/wharf/attachFile.do?action=uploadFile");
	  $("#frmfileupload").submit();
	  processing();
}

/**
 * 上传后回调方法
 * @param attachfilelistIds 业务附件文本框id
 */
function callLoadSucc(attachfilelistIds){
	closeProcessing();
	var contentWindow = document.getElementById('hidden_frame').contentWindow;
	var resultElement = contentWindow.document.getElementById("result");
	if(resultElement != null && resultElement!="null"){
		var result = resultElement.value;
		var attachFileId = contentWindow.document.getElementById("attachFileId").value;
		var origFileName = contentWindow.document.getElementById("origFileName").value;
		var relativeURL = contentWindow.document.getElementById("relativeURL").value;
		var attachfileComment = contentWindow.document.getElementById("attachfileComment").value;
		var attachfileUser = contentWindow.document.getElementById("attachfileUser").value;
		var attachfileTime = contentWindow.document.getElementById("attachfileTime").value;
		if(result=="succ"){
			if(!attachfilelistIds){
				attachfilelistIds = "attachfilelistIds";
			}
			callbackSucc(attachfilelistIds,origFileName,relativeURL,attachFileId,attachfileComment,attachfileUser,attachfileTime);
		}
		if(result=="err1"){
			alert("文件传输失败");
		}
		if(result=="err2"){
			alert("上传文件名为空");
		}
		if(result=="err3"){
			alert("上传文件出现异常");
		}
	}
}

/**
 * 上传成功后回调方法
 * @param attachfilelistIds 业务附件文本框id
 * @param origFileName 原始文件名
 * @param relativeURL 相对路径
 * @param attachFileId 文件流水号
 */
function callbackSucc(attachfilelistIds,origFileName,relativeURL,attachFileId,attachfileComment,attachfileUser,attachfileTime){	 
	    var aftablist = document.getElementById("attachfilelist");
		var rowCount = aftablist.rows.length;
		var newRow1 = aftablist.insertRow(rowCount-1);
		//序号
		var cellxh = newRow1.insertCell(0);
		cellxh.className = "center";
		cellxh.innerHTML =rowCount-1;
		//文件名称
		var cellmc = newRow1.insertCell(1);
		cellmc.className = "left";
		cellmc.innerHTML ="<img src='/resource/images/global/sub.png' width='15' height='11' title='删除附件' style='cursor:hand;padding-right:15px;'  onclick='delAttachFile(\""+attachfilelistIds+"\","+attachFileId+",this)'/><a href='"+relativeURL+"' target='_blank' title='点击查看'>"+origFileName+"</a>";
		//文件备注
		var cellbz = newRow1.insertCell(2);
		cellbz.className = "left";
		cellbz.innerHTML =attachfileComment;
		//文件上传者
		var cellUser = newRow1.insertCell(3);
		cellUser.className = "left";
		cellUser.innerHTML =attachfileUser;
		//文件上传时间
		var cellTime = newRow1.insertCell(4);
		cellTime.className = "left";
		cellTime.innerHTML =attachfileTime;
		//附件列表值
		var attfile=$("#"+attachfilelistIds).val()+","+attachFileId;
		$("#"+attachfilelistIds).val(attfile);
}

/**
 * 删除附件
 * @param attachfilelistIds 业务附件文本框id
 * @param attachFileId 附件表id
 * @param obj dom对象
 */
function delAttachFile(attachfilelistIds,attachFileId,obj){	
	if(confirm("确定要删除附件吗？")){
	   $(obj).parent().parent().remove();
//	   var rowIndex=obj.parentElement.parentElement.rowIndex;
//	   document.getElementById("attachfilelist").deleteRow(rowIndex);
	   var attfile=$("#"+attachfilelistIds).val().replace(","+attachFileId,"");
	   $("#"+attachfilelistIds).val(attfile);
	}
}