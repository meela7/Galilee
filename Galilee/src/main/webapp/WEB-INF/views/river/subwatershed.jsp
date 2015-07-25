<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=cp%>/resources/css/korea-map-font-v1.css">
<script src="http://d3js.org/d3.v3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>수계</title>
</head>
<body>
	<div class="container">
  		<h2>중권역</h2>
		<table class="table">
		    <thead>
		      <tr>
		        <th>수계</th>
		      </tr>
		    </thead>
		    
		    <tbody>
			  <c:forEach var="e" items="${subWS}" >
		      <tr>
		        <td>${e}</td>
		      </tr>
		      </c:forEach>
		    </tbody>
		</table>
		</div>
</body>

</body>
</html>