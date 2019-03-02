<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="row">

		<div class="sidenav">
			<a href="#filler">Lookup List</a> <a class="dropdown-btn">User <i
				class="fa fa-caret-down"></i></a>
			<div class="dropdown-container" style="display: block;">
				<ul class="nav" style="display: block;">
					<li><a href="SearchUser">Search</a></li>
					<li><a href="#">link 2</a>
					<li><a href="#">link 3</a>
				</ul>
			</div>
			<a href="#filler"> Filler Text</a><a href="#filler">Filler Text</a>

		</div>

		<div class="maincontent">
			<div class="header2">
				<h1 class="c2">This is search Page</h1>
				<div class="floatRight">
					<a class="nostyle Padding black borderRight" href="#filler">Quick
						Links</a> <a class="nostyle Padding black borderRight" href="#filler">Quick
						Links</a>
				</div>
			</div>
			
			<div class="topnav">
			<div>
			<button id="searchAll" >Get All Users</button>
		</div>
			</br><input id="searchByIdVal" type="text" placeholder="search by Id..." name="search">
			<button id="searchById" type="button">Search by Id</button>&nbsp;  &nbsp; &nbsp;

			</div>
			<table>
			<tbody id="userTableBody"></tbody>
			<thead>
			<tr>
			<th>Login Name</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Status ID</th>
			<th>Last Login Date</th>
			<th>Created Date</th>
			<th>Modified Date</th>
			
			</tr>
			</thead>
			</table>
		
</body>
<script>
	var restApiURL = "http://localhost:8080/restapi";

	$(document).ready(function() {
		setActiveClassInMenu("SearchUser");
	});

	function setActiveClassInMenu(activeElemnt) {
		var selectedTabElemnt = $(".nav a[href='" + activeElemnt + "']")
				.closest("li");
		$(selectedTabElemnt).addClass('active').siblings()
				.removeClass('active');
	}
</script>

<script type="text/javascript"
	src="resources/plugin/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/custom/searchUser.js"></script>
</html>