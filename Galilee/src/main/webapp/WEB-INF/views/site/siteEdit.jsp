<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���籸�� ���� ����</title>
<script type="text/javascript">
function modifySite(site){
	if(confirm('������ ���籸�� ������ �����Ͻðھ��?')){
		editForm.submit();
	}
}
</script>
</head>
<body>
<h2>���籸�� ���� ����</h2>
<form name="editForm" action="update" method="post">
<input type="hidden" name="siteid" value="${site.getSiteID()}">
ID ${site.getSiteID()}<br>
�̸� ${site.getSiteName()}<br>
��õID <input type="text" name="riverid" value="${site.getRiver()}"><br>
��õ���� ${site.getStreamOrder()}<br>
�ּ� <input type="text" name="address" value="${site.getAddress()}"><br>
<input type="button" value="����" onclick="javascript:modifySite(${site})">
</form>

</body>
</html>