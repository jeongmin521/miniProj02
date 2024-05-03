<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/css.jsp" %>
    <%@ include file="/WEB-INF/views/include/js.jsp" %>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>마이페이지</h1>
   
      <label>이름: ${member.member_name}</label> <br/>
      <label>id : ${member.member_id}</label><br/>
      <label>비밀번호 : ${member.member_pwd}</label><br/>
      <label>연락처 : ${member.member_phone_number}</label><br/>
      <label>성별 : ${member.member_gender}</label><br/>
      <label>주소 : ${member.member_address}</label><br/>
      <label>권한 : ${member.member_roles}</label><br/>
      <label>계정잠금여부 : ${member.member_account_locked}</label><br/>
      
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>