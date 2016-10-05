function juge(){
		
		var juge=1;
		var role=$("select[ name='role']").val();
		var num=$("input[name='num']").val();
		var password=$("input[name='password']").val();
		if(num==''||password==''){
			$("#information").text("");
			$("#information").text("请填写完整信息");
			return false;
		}
		
		var datas={
				"role":role,
				"num":num,
				"password":password
		}
		
		$.ajax({
				url:"loginAction_login",
				type:"post",
				async:false,
				data:datas,
				success:function(data){juge=asyncJuge(data)}
		
		});
		
		if(juge==2){
			return true;
		}
		return false;
	}
	
	function asyncJuge(data){
		console.log(data);
		if(data==="success"){
			$("#information").text("");
			return 2;
		}else if(data==="erro"){
			$("#information").text("账号密码错误");
			return 1;
		}
	}