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
<title>테스트 게시판 목록</title>
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

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}">
				<tr>
					<td><c:out value="${result.testId}"/></td>
					<td>
						<c:url var="viewUrl" value="/test/testSelect.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
							<a href="${viewUrl}"><c:out value="${result.sj}"/></a>
					</td>
					<td><c:out value="${result.userNm}"/></td>
					<td><c:out value="${result.frstRegistPnttm}"/></td>
					<td><c:out value="${result.lastUpdtPnttm}"/></td>
					<td>
						<c:url var="delUrl" value="/test/testDelete.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
						<a href="${delUrl}" class="btn-del">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
		<div id="paging_div">
			<ul class="paging_align">
				<c:url var="pageUrl" value="/test/testSelectList.do?"/>
				<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
			</ul>
		</div>
		
		<button type="button" id="btn-reg" data-href="/test/testRegist.do">등록하기</button>
		
	<script>
		$(document).ready(function(){
			$("#btn-reg").click(function() {
				location.href = $(this).data("href");
		});
		
		$(".btn-del").click(function(){
			if(!confirm("삭제하시겠습니까?")){
				return false;
			}
		});
	});
	</script>		

	
</body>
</html>