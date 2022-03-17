<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Details</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Roboto:wght@300&display=swap"
            rel="stylesheet">
    <script src="https://kit.fontawesome.com/3204349982.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="index.css">
</head>
<%
    //TODO perform search

    //TODO check if logged in
%>
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

.bottomnav a {
	margin-bottom: 30px;
	text-decoration: none;
}

.bottomnav-right {
	float: right;
	margin-right: 300px;
}

.bottomnav-text {
	width: 100 px;
}

button {
	background-color: red;
	color: white;
	border: none;
	padding: 12px 16px;
	padding: 10px;
	border-radius: 10%;
	cursor: pointer;
}

.button {
	background-color: #8b0000;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 10px;
	margin: 10px 10px;
	cursor: pointer;
}

img {
	
	margin-left: 10px;
	margin-right: 10px;
	border-radius: 10px;
	max-width: 98%;
}

.login-left {
	float: left;
	margin-top: 150px;
	margin-left: 300px;
}

.login-right {
	float: right;
	margin-top: 100px;
	margin-right: 300px;
}
</style>

<body>
	<div class="topnav">

		<div class="topnav-left">
			<div class="logo">
				<a href="index.jsp"> SalEats! </a>
			</div>
		</div>
		
		<%Cookie cookies [] = request.getCookies();
		Boolean loggedIn = false;
		int nameIndex = 0;
		for(int i = 0; i < cookies.length; i++)
			if(cookies[i].getName() != null){
				if(cookies[i].getName().equals("name"))
					nameIndex = i;
		}
		
		
		
		%>

		<div class="topnav-righthome">
			<a class="active" href="index.jsp">Home</a>

		</div>
		<div class="topnav-rightlogin">
			<a href="auth.jsp">Login/Register</a>
		</div>

		<br> <br> <br>
		<!--  HORIZONTAL LINE -->
		<hr style="background-color: #ebebeb; height: 1px; border: none;">
	</div>



<form action = "SearchDispatcher" name = "Login" method="POST">
<label for="dropdown"></label>
	<select name="dropdown" id="dropdown" style="margin-left: 40px">
		<option value="Name">Name</option>
		<option value="Category">Category</option>
	</select>


		<!--  TEXT SEARCH -->
		<label for="text ">
		<input type="text" id="wordsearch" name="wordsearch"
		style="width: 800px; margin: 5px">
		</label>


		<!-- SEARCH BUTTON -->

		<button class="btn">
			<i class="fa fa-search"></i>
		</button>

		<!--  RADIO BUTTONS -->
		<div class="bottomnav-right">
			<input type="radio" id="price" name="price" value="price">  
			<label for="price">Price</label>
			
			<input type="radio" id="Rating" name="Rating" value="Review" style= "margin-left: 40px">  
			<label for="review">Review</label>
			
			<br>  <br>
			 <input type="radio" id="Rating" name="Rating" value="Rating"> 
				<label for="rating">Rating</label><br> 
				

		</div>
		
</form>
<body>
<!-- TODO -->
</body>
</html>