<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta charset="UTF-8">  
<meta content="301645777112-2rlc9gth0f5d4reimjcm9bf0kj7ahec0.apps.googleusercontent.com"
	name="google-signin-client_id"> <!--  which one is which 
<meta name="google-signin-client_id" content="545648236359-fpt2jfndfkhrn6dvacvmel7847nsfvni.apps.googleusercontent.com">
-->
<title>Login / Register</title>
<link href="https://fonts.googleapis.com" rel="preconnect">
<link crossorigin href="https://fonts.gstatic.com" rel="preconnect">

<link
	href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<script crossorigin="anonymous"
	src="https://kit.fontawesome.com/3204349982.js"></script>
<script async defer src="https://apis.google.com/js/platform.js"></script>
<link href="index.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>

<!-- <link href="index.css" rel="stylesheet" type="text/css">   -->

<!--  linkined css file to this html file -->
<script> 
			
	function onSignIn(googleUser) {
		console.log("Google sign in");
	
	 var profile = googleUser.getBasicProfile();
			  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
			  console.log('Name: ' + profile.getName());
			  console.log('Image URL: ' + profile.getImageUrl());
			  console.log('Email: ' + profile.getEmail());
			  
			  // This is null if the 'email' scope is not present.
			  
			  var name = profile.getName();
			  var profileID = profile.getId();
			  
			window.location.href = "/karenhe_PA2/GoogleDispatcher.java?name=" + name + "&email=" + email;
			
			}
				
</script>
<!-- 
	<script>
		//waiting on these functions to see what i can do with 
			//JS to validate the login funciton
			function validateLog() {
				var xhttp = new XMLHttpRequest();
				//getting correct responses from servlet ... need to get stuff sorted in the XML
				xhttp.open("GET", "loginserv?username=" + document.login.username.value + "&password=" + document.login.password.value + "&requesttype=normal", true);
				xhttp.send();
				xhttp.onreadystatechange = function () {
					if(this.readyState == XMLHttpRequest.DONE){
						document.getElementById("loginerror").innerHTML = this.responseText;
						if(this.responseText.length > 0)
						{
							return false;
						}
						else { //i don't know if this will forward sessions or if it just redirects to the home page
							window.location = "index.jsp";
							return true;
						}
					}	
				}		
			}
			function validateReg() {
				var xhttp = new XMLHttpRequest();
				//getting correct responses from servlet ... need to get stuff sorted in the XML
				xhttp.open("GET", "registerserv?email=" + document.signup.email.value +  "&username=" + document.signup.username.value 
						+ "&password=" + document.signup.password.value + "&confirmation=" + document.signup.confirmation.value, true);
				xhttp.send();
				xhttp.onreadystatechange = function () {
					if(this.readyState == XMLHttpRequest.DONE){
						document.getElementById("registererror").innerHTML = this.responseText;
						if(this.responseText.length > 0)
						{
							return false;
						}
						else {
							window.location = "index.jsp";
							return true;
						}
					}	
				}		
			}
		</script> -->
</head>
<style>
.logo a {
	font-family: lobster;
	color: red;
	margin-left: 40px;
	font-size: 30px
}

.topnav a {
	margin-top: 15px;
	text-decoration: none;
}

.topnav-righthome {
	float: right;
	font-size: 15px;
	margin-right: 30px;
	margin-top: 15px;
}

.topnav-rightlogin {
	float: right;
	font-size: 15px;
	margin-right: 40px;
	margin-top: 15px;
}

.topnav-left {
	float: left;
	font-size: 15px;
}

.button {
	background-color: red;
	border: none;
	color: white;
	padding: 5px 100px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 10px;
	cursor: pointer;
}

.signin {
	background-color: red;
	border: none;
	color: white;
	padding: 5px 150px;
	text-align: center;
	font-size: 13px;
	cursor: pointer;
}

.login-left {
	float: left;
	margin-top: 150px;
	margin-left: 300px;
}

.login-right {
	float: right;
	margin-top: 100px;
	margin-right: 350px;
}

.g-signin2 {
	
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	font-size: 10px;
	cursor: pointer;
}
</style>



<body>


	<!-- 	<form action = "auth" method = "GET">  -->

	<!--  HEADER -->
	<!-- The <div> tag defines a division or a section in an HTML document. -->
	
	
	<div class="topnav">

		<div class="topnav-left">
			<div class="logo">
				<a href="index.jsp"> SalEats! </a>
			</div>
		</div>

		<div class="topnav-righthome">
			<a class="active" href="auth.html">Home</a>

		</div>
		<div class="topnav-rightlogin">
			<a href="auth.html">Login/Register</a>
		</div>

		<br /> <br /> <br />
		<!--  HORIZONTAL LINE -->
		<hr style="background-color: #ebebeb; height: 1px; border: none;">
	</div>






	<div class="center">

		<div class="login-left">
			<br />
			<br />
			<h1>Login</h1>
			<!--  Email  -->
			<form action = "LoginDispatcher.java" method = "POST">

			<label for="email">Email:</label><br />
			<br /> <input type="email" id="email" name="email" size=50 >
			<br /> <br /> 
			<label for="password">Password:</label><br /> <input
				type="password" id="password" name="password" size=50> <br />
			<br />
			</form>
		
			<button name = "signin" type = "submit" class="btn" style = "background: red; color: white; border: none; padding: 5px 150px; text-align: center; font-size: 13px; cursor: pointer;">
			<i class="fa fa-sign-in"></i> Sign-in
			</button>
	


			<div name = "gsignin" type = "submit" class="g-signin2" size=50>
			
		</div>
			<br /> <br />
			



	</div>

		<!--  REGISTER -->
		<div class="login-right">
			<h1>Register</h1>
			
			<form name = "RegisterDispatcher" action = "RegisterDispatcher.java" >
			<span id="registererror" class="form-error"></span>
			<label for="registerEmail">Email:</label><br /> <input type="email"
				id="registerEmail" name="registerEmail" size=60 "> <br /> <br />
			<label for="name">Name:</label><br /> <input type="text" id="Name"
				name="name" size=60> <br /> <br /> <label
				for="registerPassword">Password:</label><br /> <input
				type="password" id="registerPassword" name="registerPassword"
				size=60> <br /> <br /> <label for="confirmPassword">Confirm
				Password:</label><br /> <input type="password" id="confirmPassword"
				name="confirmPassword" size=60> <br /> <br />
				<input type="checkbox" name="agree" value="agree" />I have read and agreed
			to all terms and conditions of SalEats <br /> <br />
	
			
			
			<button name = "create" type = "submit" style = "background: red; color: white; border: none; padding: 5px 150px; text-align: center; font-size: 13px; cursor: pointer;"> <i class="	fa fa-user-plus"></i> Create Account </button>
			
			<!-- <button class="btn"> <i class="	fa fa-user-plus"></i> Create Account</button>
				 -->
			</form>
			
			
			</div>
		




	 


</body>


</html>