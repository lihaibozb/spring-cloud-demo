var baseURI = "http://www.lly824.com:8080";
$(document).ready(function() {

	$("#loginBtn").on("click", function() {
		var userName = $("#userName").val();
		var password = $("#password").val();
		ajaxServerAfun("GET", baseURI + "/service-user/v1/login", {userName: userName, password: password},
		'ea13a7c8-771c-43e2-b737-02d0569db6b4', null, null);
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
//		beforeSend: function(request) {
//			request.setRequestHeader("Authorization", "Bearer " + accecc_token);
//		},
		async: true,
		//		dataType: dataType,
		//		contentType: contentType,
		success: function(data) {
			alert(JSON.stringify(data));
			var tokenObj = JSON.parse(data);
			var TOKEN = tokenObj.access_token;
			$.cookie("TOKEN",TOKEN, {domain:'www.lly824.com'});
			location.href = "loginSuccess.html";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ' ' + errorThrown)
		}
	});
}