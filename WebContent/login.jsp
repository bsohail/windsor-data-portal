<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>

 <link rel="stylesheet" href="login.css" type="text/css">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

</head>
<body class="align">
	<div class="grid align__item">
		<div class="register">
		
			<h1>Login</h1>
			<form action="login" method="post" class="form">
				
	            
	            <div class="form__field">
	            <input type="text" name="email" size="30" placeholder="UserName" required/>
	            </div>
	            <br><br>
	            <div class="form__field">
	            <input type="password" name="password" size="30" placeholder="password" required/>
	            <div class="form__field">
	            <br>${message}
	            </div>
	            <br><br> 
	            <div class="form__field">          
	            <button type="submit">Login</button>
	            </div>
	        </form>
        </div>
	</div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>