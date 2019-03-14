<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="row">
		<!-- Side Navigation -->
		<div class="sidenav">
			<a href="#">Search</a> <a href="#">Create Investment</a> <a href="#">Filler</a>
			<a href="#">Filler</a> <a href="#">Filler</a>
		</div>

		<!-- Main Content -->
		<div class="maincontent">
			<div class="header2">
				<h1 class="c2">Create Investment</h1>
				<div class="floatRight">
					<form action="uploadFile" method="post" enctype="multipart/form-data">
						<input type="file" name="excel"> <input type="submit">
					</form>
				</div>
			</div>

			<div>
				<div class="row">
				
					<div>
						<label>Investment Name</label> <input type="text"
							name="investerName" value="${investmentName}"/>
					</div>
					<div>
						<label>Legal Close Date </label> <input type="text"
							name="legalCloseDate" value="${legalCloseDate}"/>
					</div>
					<div>
						<label>Tax Id</label> <input type="text" name="taxId"  value="${taxId}" />
					</div>
					<div>
						<label>Commitment Amount</label> <input type="text"
							name="commitmentAmount" value="${commitmentAmount}"/>
					</div>
					<div>
						<label>Relationship Client GCL</label> <input type="text"
							name="relationshipClient" value="${relationshipClient}"/>
					</div>
					<div>
						<label>Portfolio Type </label> <input type="text"
							name="portfolioType" value="${portfolioType}"/>
					</div>
					<div>
						<label>Syndicator</label> <input type="text" name="syndicator" value="${syndicator}"/> 
					</div>
					
					<div>
						<table>
							<thead>
								<tr>
									<th>Investor Name</th>
									<th>OwnerShip</th>
									<th>Bla 1</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${investerOneName}</td>
									<td>${investerOneOwnerShip}</td>
									<td>${investerOneBla1}</td>	
								</tr>
								<tr>
									<td>${investerTwoName}</td>
									<td>${investerTwoOwnerShip}</td>
									<td>${investerTwoBla1}</td>	
								</tr>
								<tr>
									<td>${investerThreeName}</td>
									<td>${investerThreeOwnerShip}</td>
									<td>${investerThreeBla1}</td>	
								</tr>
							</tbody>
						</table>
						
						<button id="saveInvestment" type="button">Save</button>
					
					</div>

				</div>
			</div>
		</div>

	</div>
</body>
<script>
	var restApiURL = "http://localhost:8080/restapi";

	$(document).ready(function() {
		setActiveClassInMenu("deal");
	});

	function setActiveClassInMenu(activeElemnt) {
		var selectedTabElemnt = $(".nav a[href='" + activeElemnt + "']")
				.closest("li");
		$(selectedTabElemnt).addClass('active').siblings()
				.removeClass('active');
	}
</script>

<script type="text/javascript" src="resources/js/custom/investment.js"></script>
</html>