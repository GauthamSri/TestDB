/**
 * 
 */

function validateEmail()
{
	var email = $('#userEmail').val();
	var url = 'RegisterController?emailid='+email;
	var str = "true";
	 $.ajax({
	        type: "GET",
	        url: url,
	        data: { email: email},
	        dataType: "text",
	        success: function (result) {
	                //alert(result);
	                
	                if(result.trim() == "true")
	                	{
	                	$('#vaildateUser').text("Username " + email + " already exists. Please provide another username");
						$('#userEmail').val("");
	                	}
	                else{
						$('#vaildateUser').text("");
					}
	                
						
	        },
	        failure: function (response) {
	            alert("Failed"+response.d);
	        }
	    });
}

function validateUser() {
	var email = $('#userEmail').val();
	var jsonURL = 'RegisterController?emailid='+ email;
	 $.getJSON(jsonURL, function(opts) {
		if (opts) {
			$.each(opts, function(key1, value1) {					
				if(value1 == true){
					$('#vaildateUser').text("Username " + email + " already exists. Please provide another username");
					$('#userEmail').val("");
				}
				else{
					$('#vaildateUser').text("");
				}
			});
		}
		else
			{
			 alert("Ajax Succeed with no result");
			}
	}); 
}