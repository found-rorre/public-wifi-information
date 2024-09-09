<%@page import="dto.HistoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.HistoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="resources/js/history.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>위치 히스토리 목록</title>
	<style type="text/css">
		body {
			font-size: 0.75rem;
		}
		
		table {
			font-size: 0.8rem;
			text-align: center;
		}
 		.history_delete_btn {
			text-decoration: underline;
			 color: blue;
		}
		.history_delete_btn:hover {
			color: red;
			cursor: pointer;
		}

	</style>
</head>
<body>

	<%
		List<HistoryDTO> historyList = null;
		
		HistoryService historyService = new HistoryService();
		historyList = historyService.getHistoryList();
		
		request.setAttribute("historyList", historyList);
		
	%>
	
	<div class="container-fluid p-5">
	
		<h2>위치 히스토리 목록</h2>
		
		<%@include file="header.jsp"%>
		<div class="pt-3">
			<table class="table table-striped table-hover pt-3">
				<thead class="table-primary">
					<tr>
						<th>ID</th>
						<th>X좌표</th>
						<th>Y좌표</th>
						<th>조회 일자</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="historyDTO" items="${historyList}">
					<tr>
						<td class="id">${historyDTO.id}</td>
						<td>${historyDTO.LAT}</td>
						<td>${historyDTO.LNT}</td>
						<td>${historyDTO.searchDate}</td>	
						<td><a class="history_delete_btn">삭제</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<form id="history_form" action="<%= request.getContextPath() %>/history-delete.jsp" method="post" hidden>
				<input name="id">
			</form>
		</div>
		
	</div>
</body>
</html>