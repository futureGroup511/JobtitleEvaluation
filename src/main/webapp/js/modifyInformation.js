var status=1;
$(function(){
	$(":button").hide();	
});
function Manager(){}
function Expert(){}

function jugeObject(role){
	var num=$("#num").val();
	var password=$("#oldpassword").val();
	if(role==1){
		var manager=new Manager();
		manager.sup_accountNum=num;
		manager.sup_password=password;
		return manager;
	}else if(role==2){
		var expert=new Expert();
		expert.exp_accountNum=num;
		expert.exp_password=password;
		return expert;
	}
}
function jugeOldPassword(url,role){
	var data=jugeObject(role);
	console.log(data);
	var juge=1;
	var title="原密码错误";
	$.ajax({
		url:url,
		type:'post',
		data:data,
		async:false,
		success:function(data){juge=asyncJuge(data,title)}
	});
	juge==2? $(":button").show():$(":button").hide();
}

function compareInput(){
	var newpassword=$("#newpassword").val();
	var secondpassword=$("#secondpassword").val();
	comparePassowrd(newpassword,secondpassword,status);
}

function comparePassowrd(value,value2,passstatus){
	$("#information").text("");
	if(value!=value2){
		if(passstatus!=1){
			$("#information").text("两次输入密码有误");
			$(":button").hide();
		} 
		status=2;
	}
	else $(":button").show();
}


