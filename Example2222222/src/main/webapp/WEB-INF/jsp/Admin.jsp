<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<div class="dropdown-container">
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
				<h1 class="c2">This is Admin Page</h1>
				<div class="floatRight">
					<a class="nostyle Padding black borderRight" href="#filler">Quick
						Links</a> <a class="nostyle Padding black borderRight" href="#filler">Quick
						Links</a>
				</div>
			</div>
			<p>This is body Pragraph</p>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}

		$(document).ready(function() {
			setActiveClassInMenu("Admin");
		});

		function setActiveClassInMenu(activeElemnt) {
			var selectedTabElemnt = $(".nav a[href='" + activeElemnt + "']")
					.closest("li");
			$(selectedTabElemnt).addClass('active').siblings().removeClass(
					'active');
		}
	</script>

</body>