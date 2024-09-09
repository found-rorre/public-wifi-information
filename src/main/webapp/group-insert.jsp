<%@page import="service.BookMarkService"%>
<%@page import="dto.BookMarkGroupDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<title>북마크 그룹 저장</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	
		BookMarkGroupDTO dto = new BookMarkGroupDTO();
		BookMarkService service = new BookMarkService();
	
		String name = request.getParameter("name");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		dto.setName(name);
		dto.setSeq(seq);
		
		service.groupInsert(dto);
	%>
	
	<script type="text/javascript">
		alert("북마크 그룹 정보를 추가하였습니다.");
		window.location = 'bookmark-group.jsp';
	</script>

</body>
</html>