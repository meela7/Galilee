<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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