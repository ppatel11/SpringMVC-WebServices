$(document).ready(function() {
	$("#searchAll").bind("click", findAllUsers);
	$("#searchById").bind("click", searchById);
	//Bind all the filter icon for show tooltip
	toolTipForColumnFilter();
});

//Kepp all user data set for filtering option
var allDataSet = null;

function findAllUsers() {

	var request = $.ajax({
		url : restApiURL + "/api/user/getAllUser",
		method : "GET",
		dataType : "json"
	});

	request.done(function(response) {
		var userTableBody = $("#userTableBody");
		$(userTableBody).empty();
		//Keep all user data set in global variable to get filter option
		allDataSet = response.data;

		$.each(response.data, function(key, userObj) {
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
				loginName : loginName
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


function toolTipForColumnFilter() {

	//Used tipso plugin for build tooltip for filtering data
    $(".columnFilterToolTip").tipso({
    	
        background: '#ABB0BE',
        delay: 20,
        hideDelay : 100,
        useTitle: false,
        position: 'top',
        showArrow: true,
        width: 350,
        tooltipHover: true,
        onBeforeShow: function (ele, tipso) {
        	//We have create temaplate in SerchUser.jsp for filter. and update it when tooltip show
        	var dataType = $(ele).attr("data-type");
        	var filterValueInObj = $(ele).attr("data-filtervalue");
        	
        	
        	var tempContent = $("#tool-tip-content").clone();
            
            $(tempContent).find("#tooltip-header-name").html("Filter by " + $(ele).attr("data-headername"));
            $(tempContent).find(".max_value").hide();
            
            
            if(dataType == "string"){
            	$(tempContent).find(".operator option[value='between']").remove();
            }
            
            ele.tipso('update', 'content', $(tempContent).removeClass("hide"));
            
            $(tempContent).find("#filter").attr("data-type" , dataType);
            $(tempContent).find("#filter").attr("data-filtervalue" , filterValueInObj);
            
            setTimeout(function () {
                $(tempContent).find(".operator").bind("change", { tooltipContent : tempContent},  changeOperator);
                $(tempContent).find("#filter").bind("click", { tooltipContent : tempContent},  filterTable);
            }, 90);

        }
    });
}

function changeOperator(event){
	
    var toolTipContent = event.data.tooltipContent;
    var selectedValue = $(this).val();
    if(selectedValue == "equal"){
    	$(toolTipContent).find(".max_value").hide();
    }else if(selectedValue == "between"){
    	$(toolTipContent).find(".max_value").show();
    }
}

function filterTable(event){
	
	var toolTipContent = event.data.tooltipContent;
	var type = $(this).attr("data-type");
	var filterValue = $(this).attr("data-filtervalue");
	var operation = $(event.data.tooltipContent).find(".operator").val();
	var filterValueMin =  $(event.data.tooltipContent).find(".min_value").val();
	var filterValueMax =  $(event.data.tooltipContent).find(".max_value").val();
	
	
	var userTableBody = $("#userTableBody");
	$(userTableBody).empty();

	$.each(allDataSet, function(key, userObj) {
		
		if(filterObject(type , operation , userObj[filterValue], filterValueMin , filterValueMax)){
			var tr = $("<tr></tr>");
			$(tr).append("<td>" + userObj.loginName + "</td>");
			$(tr).append("<td>" + userObj.firstName + "</td>");
			$(tr).append("<td>" + userObj.lastName + "</td>");
			$(tr).append("<td>" + userObj.statusId + "</td>");
			$(tr).append("<td>" + userObj.lastLoginDate + "</td>");
			$(tr).append("<td>" + userObj.createdDate+ "</td>");
			$(tr).append("<td>" + userObj.modifiedDate + "</td>");
			$(userTableBody).append(tr);
		}
		
	});
}

function filterObject(type , operation , objValue, filterValueMin , filterValueMax){
	
	if(type === "string"){
		if(operation === "equal"){
			if(objValue === filterValueMin){
				return true;
			}
		}
	}else if(type === "int"){
		
		objValue = parseInt(objValue);
		filterValueMin = parseInt(filterValueMin);
		filterValueMax = parseInt(filterValueMax);
		
		if(operation === "equal"){
			if(objValue === filterValueMin){
				return true;
			}
		}else if(operation === "between"){
			if(filterValueMin <= objValue && filterValueMax >= objValue){
				return true;
			}
		}
	}else if(type === "date"){
		
		objValue = new Date(objValue).getTime();
		filterValueMin = new Date(filterValueMin).getTime();
		filterValueMax = new Date(filterValueMax).getTime();
		
		if(operation === "equal"){
			if(objValue === filterValueMin){
				return true;
			}
		}else if(operation === "between"){
			if(filterValueMin <= objValue && filterValueMax >= objValue){
				return true;
			}
		}
	}
	
	return false;
}