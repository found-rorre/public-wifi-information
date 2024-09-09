<%@page import="service.BookMarkService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>북마크 그룹 수정</title>
	<style type="text/css">
		body {
			font-size: 0.75rem;
		}
		
		table {
			font-size: 0.8rem;
			text-align: center;
		}

	</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String seq = request.getParameter("seq");
	%>
	
	<div class="container-fluid p-5">
	
		<h2>북마크 그룹 수정</h2>
			
		<%@include file="header.jsp"%>
		
		<div class="pt-3">
		
			<form action="<%= request.getContextPath() %>/group-update.jsp" method="post">
				<table class="table">
					<tr>
						<td class="table-primary w-25">북마크 이름</td>
						<td class="text-start"><input type="text" name="name" value="<%=name%>"></td>
					</tr>
					<tr>
						<td class="table-primary">순서</td>
						<td class="text-start"><input type="text" name="seq" value="<%=seq%>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="수정"/></td>
					</tr>
				</table>
				<input name="id" value="<%=id%>" hidden>
			</form>
		
		</div>
	</div>
</body>
</html>