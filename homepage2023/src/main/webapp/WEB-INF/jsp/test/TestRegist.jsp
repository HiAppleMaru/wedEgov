<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<title>테스트</title>
<link href="/css/common.css" rel="stylesheet"  type="text/css">
<script src="https://code.jquery.com/jquery-Latest.min.js"></script>
<style>
table{border-collapse: collapse;}
th{font-weight:bold;}
th, td{padding:5px;}
a{text-decoration:underline;margin:5px;}
</style>
</head> 
<body>

	<c:choose>
		<c:when test="${not empty result.testId}">
			<c:set var="actionUrl" value="/test/testUpdate.do"/>
		</c:when>
		<c:otherwise>
			<c:set var="actionUrl" value="/test/testInsert.do"/>
		</c:otherwise>
	</c:choose>
	
 * 등록폼
<form action="${actionUrl}" method="post" name="testVO">
	<input type="hidden" id="testId" name="testId" value="${result.testId}"/>
	<br/>
	<label for="sj">제목</label>
	<input type="text" id="sj" name="sj" value="${result.sj}" placeholder="제목을 입력하세요."/>
	<br/>
	<label for="userNm">작성자</label>
	<input type="hidden" id="userNm" name="userNm" value="${USER_INFO.name}" placeholder="작성자를 입력하세요."/>
	<br/>
	<label for="cn">내용</label>
	<textarea id="cn" name="cn" placeholder="내용을 입력하세요."><c:out value="${result.cn}"/></textarea>
	<br/>
	<c:choose>
		<c:when test="${not empty result.testId}">
			<button type="submit">수정</button>
		</c:when>
		<c:otherwise>
			<button type="submit">등록</button>
		</c:otherwise>
	</c:choose>
	<a href="/test/testSelectList.do">목록</a>
</form>
	
</body>
</html>