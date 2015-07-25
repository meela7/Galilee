<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String cp = request.getContextPath(); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link href="<%=cp%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=cp%>/resources/jquery/jquery-1.11.3.min.js"></script>
		<script src="<%=cp%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

		<title>조사구간 정보 수정</title>

		<script type="text/javascript">
		function modifySite(site){
			if(confirm('정말로 조사구간 정보를 수정하시겠어요?')){
				editForm.submit();
			}
		}
		</script>
	</head>
	<body>
		<h2>조사구간 정보 수정</h2>
		<form name="editForm" action="update" method="post">
		<input type="hidden" name="siteid" value="${site.getSiteID()}">
		ID ${site.getSiteID()}<br>
		이름 ${site.getSiteName()}<br>
		하천ID <input type="text" name="riverid" value="${site.getRiver()}"><br>
		하천차수 ${site.getStreamOrder()}<br>
		주소 <input type="text" name="address" value="${site.getAddress()}"><br>
		<input type="button" value="수정" onclick="javascript:modifySite(${site})">
		</form>
	
	</body>
</html>