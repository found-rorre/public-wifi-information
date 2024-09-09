<%@page import="service.HistoryService"%>
<%@page import="dto.WifiDTO"%>
<%@page import="java.util.List"%>
<%@ page import="service.WifiService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>공공 와이파이 정보</title>
	<style type="text/css">
		body {
			font-size: 0.75rem;
		}
		
		table {
			font-size: 0.6rem;
			text-align: center;
		}

	</style>
</head>
<body>
	<%
		double lat = request.getParameter("lat") == null ? 0 : Double.parseDouble(request.getParameter("lat"));  
		double lnt = request.getParameter("lnt") == null ? 0 : Double.parseDouble(request.getParameter("lnt"));
		
		List<WifiDTO> wifiList = null;
		
		if(lat != 0 && lnt != 0) {
			WifiService wifiService = new WifiService();
			HistoryService historyService = new HistoryService();
			
			wifiList = wifiService.getWifiList(lat, lnt);
			
			historyService.historyInsert(lat, lnt);
			
			request.setAttribute("wifiList", wifiList);
			request.setAttribute("standardLat", lat);
			request.setAttribute("standardLnt", lnt);
			
			
			
		}
		
	%>
	<div class="container-fluid p-5">
	
		<h2>와이파이 정보 구하기</h2>
			
		<%@include file="header.jsp"%>
		
		<div class="d-flex flex-row pt-3">
			<div class="p-2">LAT : <input id="lat" value="<%=lat%>"></div>
			<div class="p-2">LNT : <input id="lnt" value="<%=lnt%>"></div>
			
			
			<div class="p-2"><input id="location_btn" type="button" value="내 위치 가져오기"></div>
			<div class="p-2"><input id="get_info_btn" type="button" value="근처 wifi 정보 보기"></div>
		</div>

		<table class="table table-striped table-hover ">
			<thead class="table-primary">
				<tr>
					<th>거리 (m)</th>
					<th>관리번호</th>
					<th>자치구</th>
					<th>와이파이명</th>
					<th>도로명 주소</th>
					<th>상세주소</th>
					<th>설치위치(층)</th>
					<th>설치유형</th>
					<th>설치기관</th>
					<th>서비스구분</th>
					<th>망종류</th>
					<th>설치년도</th>
					<th>실내외</th>
					<th>접속환경</th>
					<th>X좌표</th>
					<th>Y좌표</th>
					<th>작업일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="wifiDTO" items="${wifiList}">
                <tr data-lat="${wifiDTO.LAT}" data-lnt="${wifiDTO.LNT}">
                    <td class="distance"></td>
					<td>${wifiDTO.x_SWIFI_MGR_NO}</td>
					<td>${wifiDTO.x_SWIFI_WRDOFC}</td>
					<td><a href="wifi-info.jsp?id=${wifiDTO.x_SWIFI_MGR_NO}">${wifiDTO.x_SWIFI_MAIN_NM}</a></td>
					<td>${wifiDTO.x_SWIFI_ADRES1}</td>
					<td>${wifiDTO.x_SWIFI_ADRES2}</td>
					<td>${wifiDTO.x_SWIFI_INSTL_FLOOR}</td>
					<td>${wifiDTO.x_SWIFI_INSTl_TY}</td>
					<td>${wifiDTO.x_SWIFI_INSTL_MBY}</td>
					<td>${wifiDTO.x_SWIFI_SVC_SE}</td>
					<td>${wifiDTO.x_SWIFI_CMCWR}</td>
					<td>${wifiDTO.x_SWIFI_CNSTC_YEAR}</td>
					<td>${wifiDTO.x_SWIFI_INOUT_DOOR}</td>
					<td>${wifiDTO.x_SWIFI_REMARS3}</td>
					<td>${wifiDTO.LAT}</td>
					<td>${wifiDTO.LNT}</td>
					<td>${wifiDTO.WORK_DTTM}</td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	
 	</div>
	<script type="text/javascript">
        var standardLat = parseFloat('${standardLat}');
        var standardLnt = parseFloat('${standardLnt}');
        
        $('tr[data-lat][data-lnt]').each(function() {
            
            const lat =  $(this).data('lat');
            const lnt =  $(this).data('lnt');
            
            const distance = getDistanceFromLatLonInKm(lat, lnt, standardLat, standardLnt)
            
            $(this).find('.distance').text(Math.floor(distance * 1000));

        });
        
        function getDistanceFromLatLonInKm(lat1,lng1,lat2,lng2) {//lat1:위도1, lng1:경도1, lat2:위도2, lat2:경도2
            function deg2rad(deg) {
                return deg * (Math.PI/180);
            }
            var R = 6371; // Radius of the earth in km
            var dLat = deg2rad(lat2-lat1);  // deg2rad below
            var dLon = deg2rad(lng2-lng1);
            var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
            var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            var d = R * c; // Distance in km
            
            return d; 
          }
		
	</script>
		
	
	
    
</body>
</html>