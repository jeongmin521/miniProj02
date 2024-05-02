<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
    <%@ include file="/WEB-INF/views/include/css.jsp" %>
    <%@ include file="/WEB-INF/views/include/js.jsp" %>
</head>
<body>
    <h1>
        회원가입 양식
    </h1>
    <form id="rForm" method="post">
    	<input type="hidden" name="action" value="join">
        <label>아이디 : </label> <input type="text" id="member_id" name="member_id" required="required"><br/>
	      <label>비밀번호 : </label>   <input type="password" id="member_pwd" name="member_pwd" required="required"><br/>
	      <label>비밀번호확인 : </label>   <input type="password" id="member_pwd2" name="member_pwd2" required="required"><br/>
	      <label>이름 : </label>   <input type="text" id="member_name" name="member_name" required="required"><br/>
	      <label>전화번호: </label>  <input type="text" id="member_phone_number" name="member_phone_number" required="required"><br/>
	      <label>주소: </label>  <input type="text" id="member_address" name="member_address" required="required"><br/>
	   	  <label>성별: </label>  <input type="text" id="member_gender" name="member_gender" required="required"><br/>
	   <div>
	       <input type="submit" value="등록" >
	       <a href="/">취소</a>
	   </div>
    </form>
    <script>
		document.getElementById("rForm").addEventListener("submit",(e)=>{
			e.preventDefault();
			myFetch("join","rForm",(data)=>{
				if(data.status === 0){
					location = "/";
				}else{
					alert("회원가입 실패");
				}
			});
		});
    </script>          
</body>
</html>