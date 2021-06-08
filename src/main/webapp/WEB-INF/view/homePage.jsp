<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR Generator</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		console.log('homePage 로딩 완료');
		$('#generateBtn').click(function() {
			if($('#name').val() != '') {
				$.ajax({
					type:'get',
					url:'/generateQR',
					data:{'studentName' : $('#name').val(), },
					success: function(Data) {
						$('#QRZone').empty();
						$('#QRZone').append(
							'<img src="'+Data+'">'
						);
					}
				});
			} else {
				alert('이름을 선택하세요');
                $('#name').focus();
                $('#QRZone').empty();
				$('#QRZone').append(
					'<img src="resources/img/example.png">'
				);
			}
        });

	});

</script>
</head>
<body>
	<div class = "container">
		<h1>QR Generator</h1>
		<table class = "table">
			<tr>
				<td>이름</td>
				<td>
					<select name="name" id = "name" class="form-control">
						<option value="">선택</option>
						<c:forEach var = "name" items ="${StudentName}">
							<option value="${name}">${name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>QR code</td>
				<td id = "QRZone">
					<img src="resources/img/example.png">
				</td>
			</tr>
		</table>
		<button id ="generateBtn" class="btn btn-default">QR코드 생성</button>
	</div>
</body>
</html>