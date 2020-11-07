/**
 * 兼容浏览器的平面图绘制函数
 * 文件下边写了调用函数的测试用例
 */
//鼠标坐标
var mouseX1, mouseY1,mouseX2, mouseY2; 
//鼠标按下的标志
var moveflag=false;
//鼠标进入图形区域标志
var mouseEnterImage=true;

/**
 * 绘制鼠标移动过程图形
 * @param event 事件
 * @param tabIndex 图层序号
 * @param procColor 填充颜色
 */
function displayCoord(event,tabIndex,procColor){ 
   var top,left,oDiv; 
   oDiv=document.getElementById("tab_"+tabIndex); 
   top=getY(oDiv); 
   left=getX(oDiv); 
   $("#mouse_x").html((event.clientX-left+document.documentElement.scrollLeft) -2+"px"); 
   $("#mouse_y").html((event.clientY-top+document.documentElement.scrollTop) -2+"px"); 
   if(moveflag){
	  mouseX2=event.clientX;
      mouseY2=event.clientY;
      $("#tab_"+tabIndex).html(drawRect(mouseX1,mouseY1,mouseX2,mouseY2,procColor,2,2));
	}
}
//获取图层Left坐标
function getX(obj){ 
	var parObj=obj; 
	var left=obj.offsetLeft; 
	while(parObj=parObj.offsetParent){ 
		left+=parObj.offsetLeft; 
	} 
	return left; 
} 
//获取图层Top坐标
function getY(obj){ 
	var parObj=obj; 
	var top=obj.offsetTop; 
	while(parObj = parObj.offsetParent){ 
		top+=parObj.offsetTop; 
	} 
	return top; 
}
//鼠标按下动作
function mouseDown(e,tabIndex){
	var newFlag=$("#newFlag").val();
	if(newFlag==1){
		if(e.button!=2){//不鼠标右键
			if(mouseEnterImage){
			   $("#tab_"+tabIndex).css("cursor","move");
			   mouseX1=e.clientX; 
		       mouseY1=e.clientY;
			   moveflag=true;
			}
		}
	}
}
//鼠标松开动作
function mouseup(e,tabIndex,fillColor){
	var newFlag=$("#newFlag").val();
	if(newFlag==1){
		if(e.button!=2){//不鼠标右键
			if(mouseEnterImage){
			   $("#tab_"+tabIndex).css("cursor","crosshair"); 
			   mouseX2=e.clientX;
		       mouseY2=e.clientY;		 		  
		       $("#tab_"+tabIndex).html(drawFilledRect(mouseX1,mouseY1,mouseX2,mouseY2,fillColor));
		       imageHandle(mouseX1,mouseY1,mouseX2,mouseY2,fillColor);
			   moveflag=false;
			}
		}
	}
}
//鼠标进入图形
function imageOnMouseOver(img){
  img.style.cursor="help";
  mouseEnterImage=false;
}
//鼠标离开图形
function imageOnMouseOut(img){
	var newFlag=$("#newFlag").val();
	if(newFlag==1){	
       img.style.cursor="crosshair";
	}else{
		img.style.cursor="default";
	}  
  mouseEnterImage=true;
}

/************* 画实心矩形 **************
x1,y1   起点（矩形左上角）所在的屏幕坐标（像素）
x2,y2   终点（矩形右下角）所在的屏幕坐标（像素）
color   颜色（字符串值）
**********************************/
function drawFilledRect2(x1,y1,x2,y2,color){
  var strHTML="<table border='0' cellspacing=0 cellpadding=0><tr><td style='position:absolute;left:"+(x1)+"; top: "+(y1)+";background-color: "+color+"' width="+(x2-x1)+" height="+(y2-y1)+"></td></tr></table>";
  return strHTML;
}
function drawFilledRect(x1,y1,x2,y2,color){
   var strHTML="<div id='N/A' style='position:absolute;left:"+(x1)+";top:"+(y1)+";background-color:"+color+";width:"+(x2-x1)+";height:"+(y2-y1)+";' ondblclick='imageDblClick(this)' onmouseover='imageOnMouseOver(this)' onmouseout='imageOnMouseOut(this)'><div style='text-align:right;cursor:hand;z-index:10' title='删除堆位' onclick='funDel(this)'><img src='/resource/images/global/close.png'></div><div style='position:absolute;left:0px;top:0px;font-size:12px;color:red;z-index:30'><span style='color:000'>堆位编号:&nbsp;</span>未分配<br/><span style='color:000'>堆位名称:&nbsp;</span>未知</div></div>";
   return strHTML;
}
/************* 画点 **************
x,y     点所在的屏幕坐标（像素）
color   颜色（字符串值）
size    大小（像素）
**********************************/
function drawDot(x,y,color,size){
   var strHTML="<table border='0' cellspacing=0 cellpadding=0><tr><td style='position: absolute; left: "+(x)+"; top: "+(y)+";background-color: "+color+"' width="+size+" height="+size+"></td></tr></table>";
   return strHTML;
}
/************* 画直线 **************
x1,y1   起点所在的屏幕坐标（像素）
x2,y2   终点所在的屏幕坐标（像素）
color   颜色（字符串值）
size    大小（像素）
style   样式
=0    实线
=1    虚线
=2    虚实线
**********************************/
function drawLine(x1,y1,x2,y2,color,size,style){
  var strHTML="";
  var i;
  var r=Math.floor(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
  var theta=Math.atan((x2-x1)/(y2-y1));
  if(((y2-y1)<0&&(x2-x1)>0)||((y2-y1)<0&&(x2-x1)<0))
    theta=Math.PI+theta;
  var dx=Math.sin(theta);
  var dy=Math.cos(theta);
  for(i=0;i<r;i++){
     switch(style){
       case 0:
    	  strHTML=strHTML+drawDot(x1+i*dx,y1+i*dy,color,size);
          break;
       case 1:
          i+=size*2;
          strHTML=strHTML+drawDot(x1+i*dx,y1+i*dy,color,size);
          break;
       case 2:
          if(Math.floor(i/4/size)%2==0){
        	  strHTML=strHTML+drawDot(x1+i*dx,y1+i*dy,color,size);
          }else{
             i+=size*2;
             strHTML=strHTML+drawDot(x1+i*dx,y1+i*dy,color,size);
          }
          break;
       default:
    	   strHTML=strHTML+drawDot(x1+i*dx,y1+i*dy,color,size);
          break;
       }
     }
  return strHTML;
}
/************* 画矩形 **************
x1,y1   起点（矩形左上角）所在的屏幕坐标（像素）
x2,y2   终点（矩形右下角）所在的屏幕坐标（像素）
color   颜色（字符串值）
size    大小（像素）
style   样式
=0    实线
=1    虚线
=2    虚实线
**********************************/
function drawRect(x1,y1,x2,y2,color,size,style){
   var strHTML="";	
   strHTML=strHTML+drawLine(x1,y1,x2,y1,color,size,style);
   strHTML=strHTML+drawLine(x1,y2,x2,y2,color,size,style);
   strHTML=strHTML+drawLine(x1,y1,x1,y2,color,size,style);
   strHTML=strHTML+drawLine(x2,y1,x2,y2,color,size,style);
   return strHTML;
}
/************* 画椭圆 **************
x,y         中心所在的屏幕坐标（像素）
a,b         长轴和短轴的长度（像素）
color       颜色（字符串值）
size        大小（像素）
precision   边缘精细度
**********************************/
function drawOval(x,y,a,b,color,size,precision){
   var strHTML="";	
   var i;
   var iMax=2*Math.PI;
   var step=2*Math.PI/(precision*Math.sqrt(a*b)*4.5);
   for(i=0;i<iMax;i+=step){
	   strHTML=strHTML+drawDot(x+a*Math.cos(i),y+b*Math.sin(i),color,size);
   }
   return strHTML;
}
/************* 画多边形 **************
x,y     中心所在的屏幕坐标（像素）
r       多边形外接圆半径（像素）
n       多边形的边数
color   颜色（字符串值）
size    大小（像素）
style   样式
=0    实线
=1    虚线
=2    虚实线
**********************************/
function drawPoly(x,y,r,n,color,size,style){
   var strHTML="";		
   var i;
   var theta=Math.PI;
   var x1=x,y1=y-r,x2,y2;
   for(i=0;i<n;i++){
     theta-=(2*Math.PI/n);
     x2=x+r*Math.sin(theta);
     y2=y+r*Math.cos(theta);
     strHTML=strHTML+drawLine(x1,y1,x2,y2,color,size,style);
     x1=x2;
     y1=y2;
    }
   return strHTML;
}
//这个测试方法,描述各种图形的绘制
function drawLoadImage(){
	var strHTML="";
	strHTML=strHTML+drawLine(20,20,300,20,"#0000cc",2,0);
	strHTML=strHTML+drawLine(20,40,300,40,"#0000cc",2,1);
	strHTML=strHTML+drawLine(20,60,300,60,"#0000cc",2,2);
	strHTML=strHTML+drawFilledRect(20,80,300,200,"009999");
	strHTML=strHTML+drawRect(20,220,220,320,"ff0000",2,0);
	strHTML=strHTML+drawRect(240,220,440,320,"ff0000",2,1);
	strHTML=strHTML+drawRect(460,220,660,320,"ff0000",2,2);
	strHTML=strHTML+drawOval(250,450,120,50,"006600",1,1);
	strHTML=strHTML+drawOval(250,650,120,120,"006600",2,0.5);
	strHTML=strHTML+drawPoly(200,900,100,3,"ff8800",2,0);
	strHTML=strHTML+drawPoly(400,900,100,4,"ff8800",2,1);
	strHTML=strHTML+drawPoly(600,900,100,5,"ff8800",2,2);
	strHTML=strHTML+drawPoly(200,1100,100,6,"ff8800",2,0);
	strHTML=strHTML+drawPoly(400,1100,100,7,"ff8800",2,1);
	strHTML=strHTML+drawPoly(600,1100,100,12,"ff8800",2,2);
	$("#tab_1").html(strHTML);
}