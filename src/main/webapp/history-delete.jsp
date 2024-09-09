<%@page import="service.HistoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위치 히스토리 삭제</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		
		HistoryService service = new HistoryService();
		
		service.historyDelete(id);
	%>
	
	<script type="text/javascript">
		alert("히스토리를 삭제하였습니다.");
		window.location = 'index.jsp';
	</script>
</body>
</html>