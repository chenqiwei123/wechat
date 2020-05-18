document.onkeydown=function(){
    var e = window.event||arguments[0];
    if(e.keyCode==123){
    	alert('不允许看我的源码，安静的使用就好！');
            return false;
    }else if((e.ctrlKey)&&(e.shiftKey)&&(e.keyCode==73)){
    	alert('不允许看我的源码，安静的使用就好！');
            return false;
    }else if((e.ctrlKey)&&(e.keyCode==85)){
            alert('不允许看我的源码，安静的使用就好！');
            return false;
    }else if((e.ctrlKey)&&(e.keyCode==83)){
           alert('不允许看我的源码，安静的使用就好！');
           return false;
    }
}
document.oncontextmenu=function(){
	alert('不允许看我的源码，安静的使用就好！');
    return false;
}