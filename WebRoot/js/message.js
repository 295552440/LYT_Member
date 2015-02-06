	function login() {
		 
		var name = $("#userName").val();
		var pw = $("#password").val();
		 
		if (name == "" || pw == "") {
			alert("用户名或密码不能为空");
			$("#userName").focus();
			return;
		}





	}
	
	$.ajax({
		
		url:"<%=request.getContextPath()%>/user/userLogin",
		
		
		
		
		
		
	});