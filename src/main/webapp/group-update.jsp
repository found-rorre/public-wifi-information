<%@page import="service.BookMarkService"%>
<%@page import="dto.BookMarkGroupDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 그룹 수정</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BookMarkGroupDTO dto = new BookMarkGroupDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSeq(seq);
		
		BookMarkService service = new BookMarkService();
		
		service.groupUpdate(dto);
	%>
	<script type="text/javascript">
		alert("북마크 그룹를 수정하였습니다.");
		window.location = 'bookmark-group.jsp';
	</script>

</body>
</html>