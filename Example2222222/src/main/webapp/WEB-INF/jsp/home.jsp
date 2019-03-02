<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>


</head>
<body>
<div>
<jsp:include page="header.jsp"></jsp:include>
</div>

<div class="row">
<div>
<h1>This is Home Page</h1>
</div>
<p>This is paragraph</p>
</div>

<jsp:include page="footer.jsp"/>
<script>
$( document ).ready(function() {
	setActiveClassInMenu("/CARMA");	
});


function setActiveClassInMenu(activeElemnt){
	var selectedTabElemnt  = $(".nav a[href='"+activeElemnt+"']").closest("li"); 
	$(selectedTabElemnt).addClass('active').siblings().removeClass('active');
}

</script>
</body>
</html>