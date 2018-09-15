$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8088/greeting"
	}).then(function(data, status, jqxhr) {
		console.log("data", data);
		console.log("status", status);
		console.log("jqxhr", jqxhr);
		
		$('.greeting-id').append(data.id);
		$('.greeting-content').append(data.content);
	})
})