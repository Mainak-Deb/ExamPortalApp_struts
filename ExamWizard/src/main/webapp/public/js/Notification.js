$(document).ready(function() {
            // jQuery equivalent of window.onload
            fetchdata();
            
});
setInterval(fetchdata, 5000);


function fetchdata(){
	$.ajax({
                url: 'notificationContent.do',
                method: 'GET',
                success: function(data) {
                    // Replace the content of the "Notification-center" div
                    $('#notification-center').html(data);
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error:', error);
                }
            });
}
function deleteNotification(id){
		data= {
			  "nid":id,
		  }
		$.ajax({
                url: 'deleteNotification.do',
                method: 'POST',
                data:data,
                success: function(data) {
                    // Replace the content of the "Notification-center" div
                    $('#notification-center').html(data);
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error:', error);
                }
          });
}