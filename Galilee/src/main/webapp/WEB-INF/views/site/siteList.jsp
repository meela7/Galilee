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
		<title>조사구간 리스트</title>
	</head>
	<body>
		<div class="panel panel-default">
		<div class="panel-heading">조사구간 리스트</div>
		
		<!-- Table -->
		<table class="table table-condensed">
		    <thead>
		      <tr class="success">
		        <th>수계</th>
		        <th>중권역</th>
		        <th>하천명</th>
		        <th>조사구간명</th>
		        <th>하천구분</th>
		        <th>하천차수</th>
		      </tr>
		    </thead>
		    
		    <tbody>
			  <c:forEach var="e" items="${siteList}" >
		      <tr>
		        <td>${e.getRiver().getWaterSystem()}</td>		        
		        <td>${e.getRiver().getMidWatershed()}</td>
		        <td>${e.getRiver().getRiverName()}</td>
		        <td><a href="siteInfo?siteid=${e.getSiteID()}">${e.getSiteName()}</td>
		        <td>${e.getRiver().getClassification()}</td>
		        <td>${e.getStreamOrder()}</td>
		      </tr>
		      </c:forEach>
		    </tbody>
		</table>
		</div>
		<ul class="pager">
		  <li class="previous"><a href="#">Previous</a></li>
		  <li class="next"><a href="#">Next</a></li>
		</ul>
	</body>
</html>