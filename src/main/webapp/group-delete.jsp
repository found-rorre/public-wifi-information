<%@page import="service.BookMarkService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 그룹 삭제</title>
</head>
<body>
	<%
		int id =  Integer.parseInt(request.getParameter("id"));
	
		BookMarkService service = new BookMarkService();
		
		service.groupDelete(id);
	%>
	
	<script type="text/javascript">
		alert("북마크 그룹을 삭제하였습니다.");
		window.location = 'bookmark-group.jsp';
	</script>
	
</body>
</html>