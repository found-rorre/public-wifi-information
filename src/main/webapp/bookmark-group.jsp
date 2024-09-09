<%@page import="service.BookMarkService"%>
<%@page import="dto.BookMarkGroupDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="resources/js/bookmark-group.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>북마크 그룹 목록</title>
	<style type="text/css">
		body {
			font-size: 0.75rem;
		}
		
		table {
			font-size: 0.8rem;
			text-align: center;
		}
 		.group_update_btn, .group_delete_btn {
			text-decoration: underline;
			 color: blue;
		}
		.group_update_btn:hover, .group_delete_btn:hover {
			color: red;
			cursor: pointer;
		}

	</style>
</head>
<body>

	<%
		BookMarkService service = new BookMarkService();
		
		List<BookMarkGroupDTO> groupList = service.getGroupList();
		
		request.setAttribute("groupList", groupList);
	%>

	<div class="container-fluid p-5">
		<h2>북마크 그룹 목록</h2>
			
		<%@include file="header.jsp"%>
		
		<div class="pt-3">
			<input id="btn" onclick="location.href='group-add.jsp'" type="button" value="북마크 그룹 추가"/>
		</div>
		
		<div class="pt-3">
			<table class="table table-striped table-hover ">
				<thead class="table-primary">
					<tr>
						<th>ID</th>
						<th>북마크 이름</th>
						<th>순서</th>
						<th>등록일자</th>
						<th>수정일자</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="groupDTO" items="${groupList}">
					<c:set var="name" value="${fn:replace(groupDTO.name, '<', '&lt;')}"/>
					<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
					<tr>
						<td>${groupDTO.id}</td>
						<td>${name}</td>
						<td>${groupDTO.seq}</td>
						<td>${groupDTO.createDate}</td>
						<td>${groupDTO.updateDate}</td>
						<td>
							<a class="group_update_btn">수정</a>
							<a class="group_delete_btn">삭제</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<form id="group_form" method="post" hidden>
				<input name="id"/>
				<input name="name"/>
				<input name="seq"/>
			</form>
			
		</div>
		
	
	</div>

</body>
</html>