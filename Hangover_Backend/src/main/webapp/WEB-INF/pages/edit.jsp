<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>

<form action="update" method="get">
		<div class="form-row">

			<div class="form-group">
				<label for="lblcid">customer ID </label> 
				<input type="text" class="form-control" id="lblcid" name="cid" value="">
					
			</div>
			<div class="form-group">
				<label for="lblrname">Customer Name </label> 
				<input type="text" class="form-control" id="lblcname" name="cname" value="">
					
			</div>
								
			<div class="form-group">
				<label for="lblemail">Email</label> 
				<input type="email" class="form-control" id="lblemail" name="email" value=""
					placeholder="Enter Email" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="lblpassword">Password</label> 
				<input type="password" class="form-control" id="lblpassword" name="password" value="">
			</div>
		</div>
		<button type="submit" value="update" class="btn btn-primary">Login</button>
	
	</form>

</body>
</html>