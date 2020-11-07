function btnQuery(pagePerRows) {
	queryForm.action = "item.do?action=findMutiCondition&curPage=1&pageRows="+ pagePerRows;
	queryForm.submit();
}

function funAdd() {
	art.dialog.open('item.do?action=basItemAdd', {
		id : 'memdiv',
		width : 570,
		height : 260,
		title : '新增用户'
	});
}