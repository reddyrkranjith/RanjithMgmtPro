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
$(function() {
	$("input:file").change(function() {
		var fileExtension = ['xlsx'];
           if ($.inArray($(this).val().split('.').pop().toLowerCase(), fileExtension) == -1) {
                alert("Only 'xlsx' format allowed.");
                return false;
			}
		var photo = document.getElementById("file");
		var file = photo.files[0];
		var data = new FormData();
		data.append('file', file);
		$.ajax({
			url : 'uploadFile',
			type : 'POST',
			data : data,
			processData : false, // Don't process the files
			contentType : false, // Set content type to false as jQuery will tell the server its a query string request
			success : function(data, textStatus, jqXHR) {
				alert(textStatus);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseJSON.errorMessage);
				//console.log(jqXHR.responseJSON.errorMessage);
			}
		});
	});
});