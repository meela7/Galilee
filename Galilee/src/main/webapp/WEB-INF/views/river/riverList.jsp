<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<title>��õ ����Ʈ</title>
	</head>
	<body>
		<div class="container">
  		<h2>��õ ����Ʈ</h2>
		<table class="table">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>��ǿ�</th>
		        <th>����</th>
		        <th>�߱ǿ�</th>
		        <th>�ұǿ�</th>
		        <th>��õ��</th>
		        <th>��õ����</th>
		      </tr>
		    </thead>
		    
		    <tbody>
			  <c:forEach var="e" items="${riverList}" >
		      <tr>
		        <td>${e.getRiverID()}</td>
		        <td>${e.getBasin()}</td>
		        <td>${e.getWaterSystem()}</td>
		        <td>${e.getMidWatershed()}</td>
		        <td>${e.getSubWatershed()}</td>
		        <td>${e.getRiverName()}</td>
		        <td>${e.getClassification()}</td>
		      </tr>
		      </c:forEach>
		    </tbody>
		</table>
		</div>

	</body>
</html>