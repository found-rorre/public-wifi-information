$(() => {
	
	$('.bookMark_delete_btn').click(function() {
		
		if (confirm('삭제하시겠습니까?')) {
			
			const tr = $(this).closest('tr');
			const id = tr.find('td[class="id"]').text();
			
			const form = $('#bookMark_form');

			form.find('[name="id"]').val(id);
			
			form.submit();
		}

	});
});