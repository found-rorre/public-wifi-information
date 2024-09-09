<%@page import="service.BookMarkService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		String wifiId = request.getParameter("wifiId");
		
		BookMarkService service = new BookMarkService();
		
		service.markInsert(wifiId, groupId);
	%>
	<script type="text/javascript">
		alert("북마크 정보를 추가하였습니다.");
		window.location = 'bookmark-list.jsp';
	</script>
</body>
</html>