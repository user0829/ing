
function submitData(){
	var name=$("#user_name").val();
	var pass=$("#password").val();
	if(name!="" && pass!=""){
		window.location.href=basePath+"/sendInfo/index.do?name="+name+"&pass="+pass;
		window.event.returnValue=false; 
	}else{
		$("#login_form").removeClass('shake_effect');  
		setTimeout(function(){
			$("#login_form").addClass('shake_effect')
		},1);
		$("#user_name").val("");
		$("#password").val("");
		return false;
	}
}


