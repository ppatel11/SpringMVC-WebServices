<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

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
			<th>Login Name <span ><i data-type="string" data-filtervalue="loginName" data-headername="Login Name"  class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>First Name <span><i data-type="string" data-filtervalue="firstName" data-headername="First Name" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>Last Name <span><i data-type="string" data-filtervalue="lastName" data-headername="Last Name" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>Status ID <span><i data-type="status" data-filtervalue="statusId" data-headername="Status ID" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>Last Login Date <span><i  data-type="date" data-filtervalue="lastLoginDate" data-headername="Last Login Date" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>Created Date <span><i data-type="date" data-filtervalue="createdDate" data-headername="Created Date" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			<th>Modified Date <span><i data-type="date" data-filtervalue="modifiedDate" data-headername="Modified Date" class="fa fa-filter columnFilterToolTip" aria-hidden="true"></i></span></th>
			
			</tr>
			</thead>
			</table>
<div id="toolTipHide">

	<div id="tool-tip-content" class="tool-tip">
		<div class="tool-tip-header">
			<span><small id="tooltip-header-name"></small></span>
		</div>
		<!--end tool-tip-header -->
		<div class="tool-tip-body">

			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label>Operator</label>
						
						<select class="form-control operator" >
							<option value="equal">Equal</option>
							<option value="between">Between</option>
							<option value="contain">Contain</option>
						</select>
					</div>
				</div>
				
				<div class="col-xs-12 values-div hide">
					<div class="form-group">
						<label>Value</label>
						<div class="fliter-value"><input type="text" class="form-control min_value"></div>
						<div class="fliter-value"> <select class="form-control value_status" >
							<option value="1">Active</option>
							<option value="0">Disable</option>
						</select></div>
					</div>
					<div class="form-group">
						<div class="fliter-value"><input type="text" class="form-control max_value"></div>
					</div>
				</div>

			</div>

		</div>
		<div class="tool-tip-footer">
			<button id="filter" >Filter</button>
		</div>
		<!--end tool-tip-header -->
	</div>		
</div>

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

<script type="text/javascript" src="resources/js/custom/userSearch.js"></script>
</html>