 //查询用户是否重复
function sName(){
	 var s_name=document.getElementById("name").value;
	 if(s_name.length==0||s_name.trim().length==0){
		 document.getElementById("yhm").innerHTML = "用户名";
		 document.getElementById("yhm").style.color="black";
	     return;
		}
		$.ajax({
			url:"/sName",
			data:"s_name="+s_name,
			type:"get",
			dataType:"text",
			async:true,
			success:function(data){
				if(data=="true"){
					// window.location.href="/loging?uname="+uname+"&cpassword="+cpassword; 
					document.getElementById("yhm").innerHTML = "用户名已存在";
					document.getElementById("yhm").style.color="red";
				}else if(data=="false"){
					document.getElementById("yhm").innerHTML = "用户名√";
					document.getElementById("yhm").style.color="green";
				}
			},
		});
 }
 function sEmail(){
	 var s_pemail=document.getElementById("s_pemail").value;
	 var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	 if(s_pemail.length==0||s_pemail.trim().length==0){
		 document.getElementById("email").innerHTML = "邮箱";
		 document.getElementById("email").style.color="black";
	     return;
		}
		$.ajax({
			url:"/sEmail",
			data:"s_pemail="+s_pemail,
			type:"get",
			dataType:"text",
			async:true,
			success:function(data){
				if(data=="true"){
					// window.location.href="/loging?uname="+uname+"&cpassword="+cpassword; 
					document.getElementById("email").innerHTML = "邮箱已存在";
					document.getElementById("email").style.color="red";
				}else if(data=="false"){
					document.getElementById("email").innerHTML = "邮箱√";
					document.getElementById("email").style.color="green";
				} 
				if(!reg.test(s_pemail)){
					document.getElementById("email").innerHTML = "请输入正确的邮箱";
					document.getElementById("email").style.color="red";
				}
			},
		});
 }
 function login(){
	 document.getElementById("login-box").style.display="block";
 }
 //两次密码输入检测
 function sPwd(){
	var pwd1 =  document.getElementById("password").value;
	var pwd2 =  document.getElementById("pwd2").value;
	if(pwd1!=pwd2){
		document.getElementById("apwd").innerHTML = "两次密码不一致!";
		document.getElementById("apwd").style.color="red";
	}else if(pwd1==pwd2){
		document.getElementById("apwd").innerHTML = "二次密码√";
		document.getElementById("apwd").style.color="green";
	}
 }
 function zc(){
	 var yhm = document.getElementById("yhm").innerHTML;//用户名
	 var email = document.getElementById("email").innerHTML;//邮箱
	 var pwd = document.getElementById("apwd").innerHTML;//密码
	 var phone = document.getElementById("phone").innerHTML;//电话号码
	 if(yhm=="用户名√"&&email=="邮箱√"&&pwd=="二次密码√"){
		document.getElementById("reg-form").submit();
	 }else if(yhm=="用户名已存在"){
		alert("用户名已存在!");
	 }else if(email=="邮箱已存在"){
		 alert("邮箱已存在!");
	 }else if(email=="请输入正确的邮箱"){
		 alert("邮箱格式错误!");
	 }else if(pwd=="两次密码不一致"){
		 alert("两次密码不一致!");
	 }else{
		 alert("内容不能为空!");
	 }
 }