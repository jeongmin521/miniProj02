<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원정보 상세보기</title>
    <%@ include file="/WEB-INF/views/include/css.jsp" %>
    <%@ include file="/WEB-INF/views/include/js.jsp" %>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>

    <h1>
        회원정보 상세보기
    </h1>
   
      <label>이름: ${member.member_name}</label> <br/>
      <label>id : ${member.member_id}</label><br/>
      <label>연락처 : ${member.member_phone_number}</label><br/>
      <label>성별 : ${member.member_gender}</label><br/>
      <label>주소 : ${member.member_address}</label><br/>

<script>
menuActive("member_link");

function jsDelete() {
	if (confirm("정말로 삭제하시겠습니까?")) {
		myFetch("delete", "viewForm", json => {
			if(json.status == 0) {
				//성공
				alert("회원 정보를 삭제 하였습니다");
				location = "list";
			} else {
				alert(json.statusMessage);
			}
		});
	}
}

function jsUpdateForm() {
	if (confirm("정말로 수정하시겠습니까?")) {
		//서버의 URL을 설정한다 
		viewForm.action = "updateForm";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}	
}
</script>
<!-- 두개의 폼을 하나로 합치는 방법 , js를 사용하여 처리  -->
	<form id="viewForm" method="post" action="view">
		<input type="hidden" name="member_id" value="${member.member_id}">
		<input type="button" value="삭제" onclick="jsDelete()">
		<input type="button" value="수정" onclick="location.href='updateForm?bno=${member.member_id}'">
		<input type="button" value="목록" onclick ="location.href='list'">
	</form>     

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>