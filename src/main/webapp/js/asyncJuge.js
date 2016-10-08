function asyncJuge(data,title){
		$("#information").text("");
		if(data==="success")return 2;
		else if(data==="erro"){
			$("#information").text(title);
			return 1;
		}
	}