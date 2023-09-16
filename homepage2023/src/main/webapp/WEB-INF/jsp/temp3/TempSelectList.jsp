<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<title>데이터 가져오기~</title>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-Latest.min.js"></script>
<style>
table{border-collapse: collapse;}
th{font-weight:bold;}
th, td{padding:5px}
a{text-decoration:underline;margin:5px;}
</style>
</head> 
<body>
게시물 총 수 : <c:out value="${paginationInfo.totalRecordCount}"/>건
<table>
	<thead>
		<tr>
			<th>TEMP_ID</th>
			<th>TEMP_VAL</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList }"> 
			<tr>
				<td><c:out value="${result.tempId}"/></td>
				<td>
					<c:url var="viewUrl" value="/temp3/select.do">
						<c:param name="tempId" value="${result.tempId}"/>
					</c:url>
					<a href="${viewUrl}"><c:out value="${result.tempVal}"/></a>
				<%-- <td><c:out value="${result.tempVal}"/></td> --%> 
				</td> 
			</tr>
		</c:forEach>	
	</tbody>
</table>

<div id="paging_div">
	<ul class="paging_align">
		<c:url var="pageUrl" value="/temp3/selectList.do?"/>
		<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
	   <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}" />
	</ul>
</div>

<button type="button" id="btn-reg" data-href="/temp3/tempRegist.do">등록하기</button>
<script> 
$(document).ready(function(){
	//등록하기
	$("#btn-reg").click(function(){
		location.href = $(this).data("href"); 
		});
}); 
</script>
</body>
</html>