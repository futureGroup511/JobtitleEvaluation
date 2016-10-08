function juge(){
		
		var juge=1;
		var role=$("select[ name='role']").val();
		var num=$("input[name='num']").val();
		var password=$("input[name='password']").val();
		var title="账号/密码错误";
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
				success:function(data){juge=asyncJuge(data,title)}
		
		});
		
		if(juge==2)return true;
		 else return false;
	}

	