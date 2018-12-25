var baseURI = "http://www.lly824.com:8080";
$(document).ready(function() {
	$("#ajaxBtn").on("click", function() {
		alert($.cookie("TOKEN"));
		ajaxServerAfun("GET", baseURI + "/service-a/v1/accounts", {id: 1},
		$.cookie("TOKEN"), null, null);
	});
});

function ajaxServerAfun(requestType, url, data, accecc_token, dataType, contentType) {
	//	if(contentType == null) {
	//		contentType = "text/html;charset=UTF-8";
	//	}
	$.ajax({
		type: requestType,
		url: url,
		data: data,
		beforeSend: function(request) {
			request.setRequestHeader("Authorization", "Bearer " + accecc_token);
		},
		async: true,
		//		dataType: dataType,
		//		contentType: contentType,
		success: function(data) {
			alert(JSON.stringify(data));
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ' ' + errorThrown)
		}
	});
}