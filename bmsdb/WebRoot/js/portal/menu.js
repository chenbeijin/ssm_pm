var alreadyOpenTableId = null;
var hrefBaseValue = null;
var showOaMenuFlg = true;

function closeMenu() {
	if (alreadyOpenTableId == null) return;
	alreadyOpenTable = document.getElementById(alreadyOpenTableId);
	targetTableId = alreadyOpenTableId + "d";
	targetTable = document.getElementById(targetTableId);
	targetTable.style.display = "none";
	alreadyOpenTableId = null;
}

function menuClick(tableSrc) {	
	var currentTableSrc = tableSrc;
	if (currentTableSrc.id != alreadyOpenTableId) closeMenu();
	targetTableId = currentTableSrc.id+"d";
	targetTable = document.getElementById(targetTableId);
	if (targetTable.style.display == "none") {
		targetTable.style.display = '';
		alreadyOpenTableId = currentTableSrc.id;
	} else {
        targetTable.style.display = "none";
	}
}

function subMenuClick(tableSrc) {
	subTableId = tableSrc.id+"d";
	subTable = document.getElementById(subTableId);
	var tableSrcImgId = tableSrc.id + "_img";
	var tableSrcImg = document.getElementById(tableSrcImgId);
	if (subTable != null) {
		if (subTable.style.display == "none") {
			subTable.style.display = '';
			tableSrcImg.src = "/SpringMVCMybatisDemo/images/portal/menu_arrow_open.gif";
		} else {
			subTable.style.display = "none";
			tableSrcImg.src = "/SpringMVCMybatisDemo/images/portal/menu_arrow_close.gif";
		}
	}
}

function actionPage(urlValue,urlTarget) {
	if (urlValue == "") return false;
	if(urlTarget=="desktop"){
		window.parent.portalRight.location = urlValue;
	}else{
		window.open(urlValue,urlTarget);
	}	
}

function st_onload() {
	return;
}
