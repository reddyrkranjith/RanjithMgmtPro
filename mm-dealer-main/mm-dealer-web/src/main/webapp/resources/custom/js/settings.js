$(document).ready(function() {
	var data = {};
	data['department'] = $('#department option:selected').text();
	data['year'] = $("input[name='year']:checked").val();
	data['semister'] = $("input[name='semister']:checked").val();
	console.log(data);
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		dataType : "json",
		url : 'getStudents',
		type : 'POST',
		data : JSON.stringify(data),
		success : function(response) {
			console.log(response);
			$.each(response, function(key, user) {
				var htmlrow = "<tr>" +
							  "<td><input type='checkbox' class='styled'></td>" +
							  "<td>" + (key+1) + "</td>" +
							  "<td>" + user.userID + "</td>" +
							  "<td>" + user.name + "</td>" +
							  "<td>" + user.mobile + "</td>" +
							  "<td>" + user.email + "</td>" +
							  "<td>" + user.year + "</td>" +
							  "<td>" + user.uniqueId + "</td>" +
							  "<td>" + user.password + "</td>" +
							  "<td><a title='Edit' data-popup='tooltip' data-placement='left' data-original-title='Edit'>" +
							  		"<i class='icon-pencil3 position-left text-primary'></i>" +
							  		"</a><a	title='Delete' data-popup='tooltip' data-placement='right' " +
							  		"data-original-title='Delete'>" +
							  		"<i class='icon-trash position-right text-danger'></i></a></td>"+
							  "</tr>";
				$('#user_table').append(htmlrow);
			});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
});