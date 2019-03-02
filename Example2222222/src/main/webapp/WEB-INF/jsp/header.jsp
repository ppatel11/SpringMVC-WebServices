<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<div class="header">
		<div class="topHead">
			<h1 class=c1>
				<a id="logo" href="/CARMA">CARMA</a>
			</h1>
			

		</div>

		<div>
			<ul class="nav">
				<li><a href="/CARMA">Home</a></li>
				<li><a href="#deals/">Deals</a>
				<li><a href="#accounting/">Accounting</a>
				<li><a href="#report/">Report</a>
				<li><a href="Admin">Admin</a>
			</ul>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(document).on('click', 'li', function() {
			$(this).addClass('active').siblings().removeClass('active')
		})
	</script>

</body>
</html>