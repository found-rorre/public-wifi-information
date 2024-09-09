$(() => {
	
	$('#bookmark_insert_btn').click(() => {
		
		const groupId = $('#group_select').val();  // 선택된 옵션의 value 값 가져오기
		const form = $('#mark_form');
		
		if (groupId === "default") {
		    alert("북마크 이름을 선택하세요.");
		    return;
		}
		
		form.find('[name="groupId"]').val(groupId);
		
		form.submit();
		
	});
	
});


  
