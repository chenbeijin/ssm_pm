/*******公用js方法********/
/** 通用初始化加载js**/
(function($){ 
	//加载table行点击变色事件
	$(".table tbody tr").click(function(){
		$(this).addClass("hover").siblings().removeClass("hover");
	});
	//复选框table行点击选中checkbox事件
	$(".chkTable tbody tr").children().slice(1).click(function(){
		var $chk = $(this).siblings().first().find("input[type=checkbox]");
		if($chk.prop("checked")){
			$chk.prop("checked",false);
		}else{
			$chk.prop("checked",true);
		}
	});
	// formly表单美化
	// $('.formly').formly();
	
	//禁用backspace键的后退功能
	//禁止后退键 作用于Firefox、Opera  
//	document.onkeypress=banBackSpace;  
	//禁止后退键  作用于IE、Chrome  
//	document.onkeydown = banBackSpace;
	$(document).keydown(function(e){
		//判断按键为backSpace键  
        if(e.keyCode==8){
            //获取按键按下时光标做指向的element  
        	var elem = e.relatedTarget || e.srcElement || e.target ||e.currentTarget;    
              
            //判断是否需要阻止按下键盘的事件默认传递  
            var name = elem.nodeName;  
              
            if(name!='INPUT' && name!='TEXTAREA'){  
                return _stopIt(e);  
            }  
            var type_e = elem.type.toUpperCase();  
            if(name=='INPUT' && (type_e!='TEXT' && type_e!='TEXTAREA' && type_e!='PASSWORD' && type_e!='FILE')){  
                    return _stopIt(e);  
            }  
            if(name=='INPUT' && (elem.readOnly==true || elem.disabled ==true)){  
                    return _stopIt(e);  
            }  
        }  
    });  
	function _stopIt(e){  
        if(e.returnValue){  
            e.returnValue = false ;  
        }  
        if(e.preventDefault ){  
            e.preventDefault();  
        }                 
        return false;  
	}    
})(jQuery); 