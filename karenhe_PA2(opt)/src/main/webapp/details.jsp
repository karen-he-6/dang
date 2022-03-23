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

<% Business restaurant = (Business) request.getAttribute("business");
	String name = restaurant.getName();
	String address = restaurant.getAddress();
	String url = restaurant.getUrl();
	String image = restaurant.getImageUrl();
	int rating = restaurant.getRating();
	String yelp_id = restaurant.yelp_id;
	String phone_number = restaurant.getdisplayNumber();
	String [] categories = restaurant.getCat();
	String allCat = "";
	for(int i=0; i<categories.length; i++){
		allCat = categories[i] + " ";
	}
	String price = restaurant.price;%>
<div style="padding-left: 5vw; padding-right: 5vh">	
	<h1 style="color: grey; font-weight: normal;" id="restaurant_name"><%= name %></h1>
</div>
<div style="color: grey; padding-left: 5vw; padding-right: 5vw;">
	<!-- <div style="border-bottom: 1px dashed grey; border-top: 1px dashed grey; height: 55vh" > -->
	<h1> <%= name %></h1>
	<table>
		<tr style="display:block; height: 35vh; object-fit: fill">
			<td style="object-fit: fill; width: 40vh; padding-left: 4vw;" valign="middle">
				<div style="display: block; height: 34vh; width: 34vh; padding-top: 3vh; padding-bottom: 3vh;">
					<a href="<%= url %>">
					<img src="<%= image %>" style="object-fit: fill;border-radius: 30px;" width="100%" height="100%">
					</a>
				</div>
			</td>
			<td style="object-fit: fill; width: 90vh; padding-left: 7%; height: 100%; float: top;" valign="top">
				<div style="display: block; height: 100%; float: top; padding-top: 2vh;">
					<h3 style="font-weight: normal;" id="address">Address: <%= address%></h3>
					<h3 style="font-weight: normal;"> <%= phone_number%></h3>
					<h3 style="font-weight: normal;">Categories: <%= allCat %></h3>
					<h3 style="font-weight: normal;">Price: <%= price %></h3>
					<h3 style="font-weight: normal;">Rating: <%for(int i=0; i<rating; i++){%> <i class="fas fa-star"></i> <%} %></h3></a><br>
				</div>
			</td>
		</tr>
	</table>
	
	<!-- </div> -->
</div>



<body>
<!-- TODO -->
</body>
</html>