$(document).ready(function() {
	$("#searchAll").bind("click", findAllUsers);
	$("#searchById").bind("click", searchById);

});

function findAllUsers() {

	var request = $.ajax({
		url : restApiURL + "/api/user/getAllUser",
		method : "GET",
		dataType : "json"
	});

	request.done(function(response) {
		var userTableBody = $("#userTableBody");
		$(userTableBody).empty();

		$.each(response.data, function(key, userbj) {
			var tr = $("<tr></tr>");
			$(tr).append("<td>" + userObj.loginName + "</td>");
			$(tr).append("<td>" + userObj.firstName + "</td>");
			$(tr).append("<td>" + userObj.lastName + "</td>");
			$(tr).append("<td>" + userObj.statusId + "</td>");
			$(tr).append("<td>" + userObj.lastLoginDate + "</td>");
			$(tr).append("<td>" + userObj.createdDate+ "</td>");
			$(tr).append("<td>" + userObj.modifiedDate + "</td>");
			$(userTableBody).append(tr);
		});
	});

	request.fail(function(jqXHR, textStatus) {
		alert("Somthing went wrong");
	});
}

function searchById() {

	var loginName = $("#searchByIdVal").val().trim();

	if (loginName) {

		var request = $.ajax({
			url : restApiURL + "/api/user/getUserById",
			method : "GET",
			data : {
				loginNme : searchId
			},
			dataType : "json"
		});

		request.done(function(response) {
			
			var userTableBody = $("#userTableBody");
			$(userTableBody).empty();

			var userObj = response.data;

			if(userObj){
				var tr = $("<tr></tr>");
				$(tr).append("<td>" + userObj.loginName + "</td>");
				$(tr).append("<td>" + userObj.firstName + "</td>");
				$(tr).append("<td>" + userObj.lastName + "</td>");
				$(tr).append("<td>" + userObj.statusId + "</td>");
				$(tr).append("<td>" + userObj.lastLoginDate + "</td>");
				$(tr).append("<td>" + userObj.createdDate+ "</td>");
				$(tr).append("<td>" + userObj.modifiedDate + "</td>");
				$(userTableBody).append(tr);	
			}else{
				alert(response.message[0]);
			}
		});

		request.fail(function(jqXHR, textStatus) {
			alert("Somthing went wrong");
		});
	} else {
		alert("Enter valid input");
	}
}