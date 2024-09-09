<%@page import="service.BookMarkService"%>
<%@page import="dto.BookMarkGroupDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>북마크 그룹 추가하기</title>
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
	
	<div class="container-fluid p-5">
	
		<h2>북마크 그룹 추가하기</h2>
			
		<%@include file="header.jsp"%>
		
		<div class="pt-3">
		
			<form action="<%= request.getContextPath() %>/group-insert.jsp" method="post">
				<table class="table">
					<tr>
						<td class="table-primary w-25">북마크 이름</td>
						<td class="text-start"><input type="text" name="name"></td>
					</tr>
					<tr>
						<td class="table-primary">순서</td>
						<td class="text-start"><input type="text" name="seq"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="추가"/></td>
					</tr>
				</table>
			</form>
		
		</div>
		
		
	</div>

</body>
</html>