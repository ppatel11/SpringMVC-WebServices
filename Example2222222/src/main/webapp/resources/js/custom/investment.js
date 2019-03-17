/**
 * 
 */
$(document).ready(function() {
	$("#saveInvestment").bind("click", saveInvestment);
});

function saveInvestment(){
	
	var investMentName = $("input[name='investmentName']").val().trim();
	if(investMentName){
		
		var data = {};
		data.name =  $("input[name='investmentName']").val().trim();
		data.legalCloseDate =  $("input[name='legalCloseDate']").val().trim();
		data.taxId =  $("input[name='taxId']").val().trim();
		data.commitmentAmount =  $("input[name='commitmentAmount']").val().trim();
		data.relationshipClient =  $("input[name='relationshipClient']").val().trim();
		data.portfolioType =  $("input[name='portfolioType']").val().trim();
		data.syndicator =  $("input[name='syndicator']").val().trim();
		
		var investors = [];
		
		$.each($("#investerDetails tr"), function(key, tr) {
			
			var investorDetil = {};
			investorDetil.name = $(tr).find(".investerName").html().trim();
			investorDetil.ownership = $(tr).find(".investerOwnerShip").html().trim();
			investorDetil.blaOne = $(tr).find(".investerBla1").html().trim();
			investors.push(investorDetil);
			
		});
		
		data.investors = JSON.stringify(investors);
		console.log(data);
		//Send Ajax Request for save investor data
		var request = $.ajax({
			url : restApiURL + "/api/investment/saveInvestment",
			method : "POST",
			data : data,
			dataType : "json"
		});

		request.done(function(response) {
			
			alert("Save Successfully!!!");
		});
	}else{
		alert("Investment Name cannot be empty");
	}
}