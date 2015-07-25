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
		<script src="<%=cp%>/resources/jquery/jquery-1.11.3.min.js"></script>
		<script src="<%=cp%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

		<title>���籸�� ������</title>
		<script type="text/javascript">
			function deleteSite(siteid){
				if(confirm('������ �����Ͻðھ��?')){
					location.href='delete?siteid='+siteid;
				}
			}
		</script>
	</head>
	
	<body>
		<div class="container">
		  <h2>���籸�� ������</h2>
		  <form class="form-horizontal" role="form" id="insert" modelAttribute="site" method="post" action="insert">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="SiteName">���籸����:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" path="SiteName" id="SiteName" placeholder="${site.getSiteName()}">
		      </div>
		    </div>
		    
		    <div class="form-group has-feedback">
		      <label class="control-label col-sm-2" for="RiverName">��õ��:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="RiverName" placeholder="${site.getRiver()}">
		        <span class="glyphicon glyphicon-search form-control-feedback"></span>  	
		      </div>      
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="Latitude">�浵:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="Latitude" placeholder="${site.getLatitude()}">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="Longitude">����:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="Longitude" placeholder="${site.getLongitude()}">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="StreamOrder">��õ ����:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="StreamOrder" placeholder="${site.getStreamOrder()}">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="StreamGrade">��õ ���:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="StreamGrade" placeholder="${site.getStreamGrade()}">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="Address">�ּ�:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="Address" placeholder="${site.getAddress()}">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="StandardStructure">��ǥ������:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="StandardStructure" placeholder="${site.getStandardStructure()}">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="WQMN">����������: </label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="WQMN" placeholder="${site.getWQMN()}">
		      </div>
		    </div>
		    
		    <div class="form-group has-feedback">
		      <label class="control-label col-sm-2" for="Image">���� ���ε�: </label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="Image" placeholder="${site.getImage()}">
		        <span class="glyphicon glyphicon-upload  form-control-feedback"></span>
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="Description">���: </label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="Description" placeholder="${site.getDescription()}">
		      </div>
		    </div>
		    
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        
		        <a href="edit?siteid=${site.getSiteID()}"><button type="button" class="btn btn-primary">����</button></a>
				<a href="javascript:deleteSite(${site.getSiteID()})"><button type="button" class="btn btn-primary">����</button></a>
		      </div>
		    </div>
		    
		  </form>
		  </div>
	</body>
</html>