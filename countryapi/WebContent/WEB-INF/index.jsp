<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No Title</title>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		type: "get",
		url: "http://10.10.20.30:8080/countryapi/country/india",
		dataType: "application/xml",
		success: function(xml) {
		 	console.log(xml);
		}
	});
});
$("#country").on("change",function(){
	
});
$("#state").on("change",function(){
	
});
$("#city").on("change",function(){
	
});
</script>
</head>
<body>
	<div id="country">
		<select>
		</select>
	</div>
	<div id="state">
		<select>
		</select>
	</div>
	<div id="city">
		<select>
		</select>
	</div>
	<div id="zipcode">
		<select>
		</select>
	</div>
</body>
</html>