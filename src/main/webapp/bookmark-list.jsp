<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="service.BookMarkService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="resources/js/bookMark-delete.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>북마크 보기</title>
	<style type="text/css">
		body {
			font-size: 0.75rem;
		}
		
		table {
			font-size: 0.8rem;
			text-align: center;
		}
		.bookMark_delete_btn {
			text-decoration: underline;
			 color: blue;
		}
		.bookMark_delete_btn:hover {
			color: red;
			cursor: pointer;
		}

	</style>
</head>
<body>

	<%
		BookMarkService service = new BookMarkService();
		List<HashMap<String, Object>> markList = service.getMarkList();
		
		request.setAttribute("markList", markList);
	%>
	
	<div class="container-fluid p-5">
	
		<h2>북마크 보기</h2>
			
		<%@include file="header.jsp"%>
		<div class="pt-3">
			<table class="table table-striped table-hover ">
				<thead class="table-primary">
					<tr>
						<th>ID</th>
						<th>북마크 이름</th>
						<th>와이파이명</th>
						<th>등록일자</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
	 				<c:forEach var="data" items="${markList}">
					<c:set var="groupName" value="${fn:replace(data.groupName, '<', '&lt;')}"/>
					<c:set var="groupName" value="${fn:replace(groupName, '>', '&gt;')}"/>
	 				<tr>
						<td class="id">${data.id}</td>
						<td>${groupName}</td>
						<td><a href="wifi-info.jsp?id=${data.wifiId}">${data.wifiName}</a></td>
						<td>${data.createDate}</td>
						<td><a class="bookMark_delete_btn">삭제</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<form id="bookMark_form" action="<%= request.getContextPath() %>/bookMark-delete.jsp" method="post" hidden>
				<input name="id">
			</form>
		</div>
		
	</div>
</body>
</html>