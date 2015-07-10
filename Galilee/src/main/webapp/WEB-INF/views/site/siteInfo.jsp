<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String cp = request.getContextPath(); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">   -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<title>조사구간 상세정보</title>
		<script type="text/javascript">
			function deleteSite(siteid){
				if(confirm('정말로 삭제하시겠어요?')){
					location.href='delete?siteid='+siteid;
				}
			}
		</script>
	</head>
	<body>
		<div class="panel panel-default">
		<div class="panel-heading">조사구간 상세정보</div>
		
		
		
		<!-- Table -->
		<table class="table">
		    <thead>
		      <tr>
		        <th>SiteID</th>
		        <th>SiteName</th>
		        <th>RiverID</th>
		        <th>StreamOrder</th>
		        <th>StandardStructure</th>
		        <th>Address</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>${site.getSiteID()}</td>
		        <td>${site.getSiteName()}</td>
		        <td>${site.getRiver()}</td>
		        <td>${site.getStreamOrder()}</td>
		        <td>${site.getStructure()}</td>
		        <td>${site.getAddress()}</td>
		      </tr>
		      
		    </tbody>
		</table>
		<a href="edit?siteid=${site.getSiteID()}">수정</a>
		<a href="javascript:deleteSite(${site.getSiteID()})">삭제</a>
		</div>
		
	</body>
</html>