<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/view/layout/header.jsp" />

<div style="text-align: center;">

<!-- 비로그인상태 -->
<c:if test="${not login }">
<strong>로그인이 필요합니다</strong><br>
<button onclick='location.href="/users/login";'>로그인</button>
<button onclick='location.href="/users/join";'>회원가입</button>
</c:if>

<!-- 로그인상태 -->
<c:if test="${login }">
<strong>${users.u_id } 님, 환영합니다</strong><br>
<button onclick='location.href="/usersmanage/paginglist";'>게시판 가기</button>
<button onclick='location.href="/users/logout";'>로그아웃</button>
</c:if>
</div>





