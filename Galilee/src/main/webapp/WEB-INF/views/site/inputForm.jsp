<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���籸�� �߰�</title>  
</head>  
<body>  
 <center>  
  
  <h2>���籸�� �߰�</h2> 

  <form:form id="insert" modelAttribute="site" method="post"  
   action="insert">  
   <table width="400px" height="150px">  
    <tr>  
     <td><form:label path="empno">���</form:label>  
     </td>  
     <td><form:input path="empno" />  
     </td>  
    </tr>  
    <tr>  
     <td><form:label path="ename">�̸�</form:label>  
     </td>  
     <td><form:input path="ename" />  
     </td>  
    </tr>  
    <tr>  
     <td><form:label path="deptno">�μ�</form:label>  
     </td>  
     <td><form:input path="deptno" />  
     </td>  
    </tr>  
    <tr>  
     <td><form:label path="job">����</form:label>  
     </td>  
     <td><form:input path="job" />  
     </td>  
    </tr>  
    <tr>  
     <td><form:label path="sal">�޿�</form:label>  
     </td>  
     <td><form:input path="sal" />  
     </td>  
    </tr> 
    <tr>  
     <td></td>  
     <td><input type="submit" value="�� ��" /></td>  
    </tr>  
   </table>  
  </form:form>  
  
  
  <a href="list">���籸�� ���� ����Ʈ</a>  
 </center>
</body>
</html>