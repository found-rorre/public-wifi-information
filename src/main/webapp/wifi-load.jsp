<%@page import="api.WifiAPI"%>
<%@page import="service.WifiService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		WifiService service = new WifiService();
    	WifiAPI api = new WifiAPI();
    	
    	service.getData();
    	int cnt = api.getTotalCnt();

    	request.setAttribute("cnt", cnt);
	    
	%>
	<h1><%= cnt %>개의 WIFI 정보를 정상적으로 저장했습니다.</h1>
	<a href="index.jsp">홈으로 돌아가기</a>
</body>
</html>