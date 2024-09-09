<%@page import="dto.BookMarkGroupDTO"%>
<%@page import="service.BookMarkService"%>
<%@page import="service.WifiService"%>
<%@page import="dto.WifiDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="resources/js/wifi-info.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>Insert title here</title>
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
		String id = request.getParameter("id");  
	
		WifiService wifiService = new WifiService();
		BookMarkService markService = new BookMarkService();
		
		List<BookMarkGroupDTO> groupList = markService.getGroupList();
		WifiDTO wifiDTO = wifiService.getWifiInfo(id);
		
		request.setAttribute("wifiDTO", wifiDTO);
		request.setAttribute("groupList", groupList);
		
	%>	
	<div class="container-fluid p-5">
	
		<h2>와이파이 상세 정보</h2>	
		
		<%@include file="header.jsp"%>
		
		<div class="d-flex flex-row pt-3">
			<div class="p-3">
				<select id="group_select">
					<option value="default">북마크이름선택</option>
				<c:forEach var="groupDTO" items="${groupList}">
					<c:set var="name" value="${fn:replace(groupDTO.name, '<', '&lt;')}"/>
					<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
					<option value="${groupDTO.id}">${name}</option>
				</c:forEach>
						
				</select>
			</div>
			
			<div class="p-3"><input id="bookmark_insert_btn" type="button" value="즐겨찾기 추가하기"></div>
			<form id="mark_form" action="<%= request.getContextPath() %>/bookmark_insert.jsp" method="post" hidden>
				<input name="groupId" value=""/>
				<input name="wifiId" value="${wifiDTO.x_SWIFI_MGR_NO}"/>
			</form>
		</div>	
		
		<table class="table">
			<tr>
				<td class="table-primary">관리번호</td>
				<td>${wifiDTO.x_SWIFI_MGR_NO}</td>
			</tr>
			<tr>
				<td class="table-primary">자치구</td>
				<td>${wifiDTO.x_SWIFI_WRDOFC}</td>
			</tr>
			<tr>
				<td class="table-primary">와이파이명</td>
				<td>${wifiDTO.x_SWIFI_MAIN_NM}</td>
			</tr>
			<tr>
				<td class="table-primary">도로명 주소</td>
				<td>${wifiDTO.x_SWIFI_ADRES1}</td>
			</tr>
			<tr>
				<td class="table-primary">상세주소</td>
				<td>${wifiDTO.x_SWIFI_ADRES2}</td>
			</tr>
			<tr>
				<td class="table-primary">설치위치(층)</td>
				<td>${wifiDTO.x_SWIFI_INSTL_FLOOR}</td>
			</tr>
			<tr>
				<td class="table-primary">설치유형</td>
				<td>${wifiDTO.x_SWIFI_INSTl_TY}</td>
			</tr>
			<tr>
				<td class="table-primary">설치기관</td>
				<td>${wifiDTO.x_SWIFI_INSTL_MBY}</td>
			</tr>
			<tr>
				<td class="table-primary">서비스구분</td>
				<td>${wifiDTO.x_SWIFI_SVC_SE}</td>
			</tr>
			<tr>
				<td class="table-primary">망종류</td>
				<td>${wifiDTO.x_SWIFI_CMCWR}</td>
			</tr>
			<tr>
				<td class="table-primary">설치년도</td>
				<td>${wifiDTO.x_SWIFI_CNSTC_YEAR}</td>
			</tr>
			<tr>
				<td class="table-primary">실내외</td>
				<td>${wifiDTO.x_SWIFI_INOUT_DOOR}</td>
			</tr>
			<tr>
				<td class="table-primary">접속환경</td>
				<td>${wifiDTO.x_SWIFI_REMARS3}</td>
			</tr>
			<tr>
				<td class="table-primary">X좌표</td>
				<td>${wifiDTO.LAT}</td>
			</tr>
			<tr>
				<td class="table-primary">Y좌표</td>
				<td>${wifiDTO.LNT}</td>
			</tr>
			<tr>
				<td class="table-primary">작업일자</td>
				<td>${wifiDTO.WORK_DTTM}</td>
			</tr>
			
		</table>
	</div>

</body>
</html>