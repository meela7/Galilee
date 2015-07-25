<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>조사구간 추가</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>조사구간 추가</h2>
		<form class="form-horizontal" role="form" id="insert"
			modelAttribute="site" method="post" action="insert">
			<div class="form-group">
				<label class="control-label col-sm-2" for="SiteName">조사구간명:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" path="SiteName"
						id="SiteName" placeholder="Enter Site Name">
				</div>
			</div>

			<div class="form-group has-feedback">
				<label class="control-label col-sm-2" for="RiverName">하천명:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="RiverName"
						placeholder="Search River by Name"> <span
						class="glyphicon glyphicon-search form-control-feedback"></span>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="Latitude">경도:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="Latitude"
						placeholder="Enter Latitude">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="Longitude">위도:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="Longitude"
						placeholder="Enter Longitude">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="StreamOrder">하천
					차수:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="StreamOrder"
						placeholder="Enter StreamOrder">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="StreamGrade">하천
					등급:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="StreamGrade"
						placeholder="Enter StreamGrade">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="Address">주소:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="Address"
						placeholder="Enter Address">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="StandardStructure">대표구조물:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="StandardStructure"
						placeholder="Enter StandardStructure">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="WQMN">수질측정망: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="WQMN"
						placeholder="Enter WQMN">
				</div>
			</div>

			<div class="form-group has-feedback">
				<label class="control-label col-sm-2" for="Image">사진 업로드: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="Image"
						placeholder="Enter Image"> <span
						class="glyphicon glyphicon-upload  form-control-feedback"></span>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="Description">비고:
				</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="Description"
						placeholder="Enter Description">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">조사구간 추가</button>
				</div>
			</div>

		</form>
		<div class="panel panel-default">
			<div class="panel-body">
				<a href="list">조사구간 정보 리스트</a>
			</div>
		</div>

	</div>
</body>
</html>