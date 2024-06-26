<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Home
</h1>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
<c:choose>
	<c:when test="${empty principal}">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/login/loginForm">로그인</a></li>
			<li class="nav-item"><a class="nav-link" href="/member/joinForm">회원가입</a></li>
		</ul>
	</c:when>
	<c:when test="${principal.member_roles eq 'ADMIN'}">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/login/logout">로그아웃</a></li>
			<li class="nav-item"><a class="nav-link" href="/admin/list">회원관리</a></li>
			<li class="nav-item"><a class="nav-link" href="/board/list">게시물 목록</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		이름 : ${principal.member_name}
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/member/myPage?member_id=${principal.member_id}">마이페이지</a></li>
			<li class="nav-item"><a class="nav-link" href="/login/logout">로그아웃</a></li>
			<li class="nav-item"><a class="nav-link" href="/board/list">게시물 목록</a></li>
		</ul>
	</c:otherwise>
</c:choose>

</body>
</html>