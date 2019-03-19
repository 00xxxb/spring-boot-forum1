          (function(){
            var btn = document.getElementById('user');
  			var box = document.getElementById('login-box');
  			var timer = null; 
  				box.onmouseover = btn.onmouseover = function(){
    		if(timer) clearTimeout(timer)
      			box.style.display = 'block';
  					}
  				box.onmouseout = btn.onmouseout = function(){
    			timer = setTimeout(function(){
     		    box.style.display = 'none';
    		},400);
  		}
	})();
          
     //登陆方法
          function mybutton(){
      		var s_name=document.getElementById("s_name").value;
      		var s_password=document.getElementById("s_password").value;
      		$.ajax({
      			url:"/login",
      			data:"s_name="+s_name+"&s_password="+s_password,
      			type:"get",
      			dataType:"text",
      			async:true,
      			success:function(data){
      				if(data=="true"){
      					// window.location.href="/loging?uname="+uname+"&cpassword="+cpassword; 
      					window.location.href="/kh";
      				}else if(data=="false"){
      					alert("用户名或者密码错误");
      				}
      			},
      		});
      	}

     
     //退出登录
     function logout(){
    	 window.location.href="/logout";
     }
     
     //用户注册
     function zhuce(){
    	 window.location.href="/User";
     }
     
     //用户中心
     function usercenter(){
    	 window.location.href="/UserCenter"
     }