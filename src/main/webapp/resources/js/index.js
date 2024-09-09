$(() => {
	
	$('#get_info_btn').click(() => {
	    var lat = $('#lat').val();
	    var lnt = $('#lnt').val();
		
		window.location = `index.jsp?lat=${lat}&lnt=${lnt}`;
	});
	
	$('#location_btn').click(() => {
	    const $lat = $('#lat');
	    const $lnt = $('#lnt');

	    // Geolocation API 지원 여부 확인
	    if ('geolocation' in navigator) {
			navigator.geolocation.getCurrentPosition(
	        	position => {
	          		const { latitude, longitude, accuracy } = position.coords;
	          		$lat.val(latitude);
			  		$lnt.val(longitude);
	        	},
	         	error => {
	          		$lat.val(0);
	          		$lnt.val(0);
	        	},
				{
					enableHighAccuracy: true, // 정확도 우선 모드
					timeout: 10000,           // 10초 이내에 응답 없으면 에러 발생
					maximumAge: 0             // 항상 최신 위치 정보 수집
				}
			);
		} else {
			$lat.val(0);
			$lnt.val(0);
	    }
	});
	
});


  
