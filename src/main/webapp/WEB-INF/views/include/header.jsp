<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%-- 로그인 사용자 정보 --%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<ul class="nav nav-pills nav-justified">
  <li class="nav-item">
    <a class="nav-link"  href="<c:url value='/'/>" id="home_link">홈</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value='/board/list'/>" id="board_link">게시물</a>
  </li>
  	<c:choose>
	  	<c:when test="${principal.member_roles eq 'ADMIN'}">
			<li class="nav-item">
		    	<a class="nav-link" href="<c:url value='/admin/list'/>" id="member_link">회원관리</a>
		    </li>
		    <li class="nav-item">
		    	<a class="nav-link" href="<c:url value='/login/logout'/>" id="login_link">${principal.member_name} 로그아웃</a>
		    </li>
		</c:when>
  		<c:when test="${empty principal}">
			<li class="nav-item">
		    	<a class="nav-link" href="<c:url value='/member/loginForm'/>" id="login_link">로그인</a>
			</li>
  		</c:when>
  		<c:otherwise>
			<li class="nav-item">
			    <a class="nav-link" href="<c:url value='/login/logout'/>" id="login_link">${principal.member_name} 로그아웃</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="<c:url value='/member/myPage?member_id=${principal.member_id}'/>" id="mypage_link">나의정보</a>
			</li>
  		</c:otherwise>
  	</c:choose>
</ul>