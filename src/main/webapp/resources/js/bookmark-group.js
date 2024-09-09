$(() => {
	$('.group_update_btn').click(function() {
		
		if (confirm('수정하시겠습니까?')) {
			
			const tr = $(this).closest('tr');
			const data = tr.find('td');

			const form = $('#group_form');

			form.attr('action', '/public-wifi-information/group-edit.jsp');
			
			form.find('[name="id"]').val(data.eq(0).text());
			form.find('[name="name"]').val(data.eq(1).text());
			form.find('[name="seq"]').val(data.eq(2).text());

			form.submit();	
		}
		
		
		
		
	});
	
	
	
	$('.group_delete_btn').click(function() {
		
		if (confirm('삭제하시겠습니까?')) {
			const tr = $(this).closest('tr');
			const data = tr.find('td');

			const form = $('#group_form');

			form.attr('action', '/public-wifi-information/group-delete.jsp');

			form.find('[name="id"]').val(data.eq(0).text());

			form.submit();
		}

	});
});