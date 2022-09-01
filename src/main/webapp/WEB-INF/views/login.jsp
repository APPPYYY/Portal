<!doctype html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Login</title>

<style>
body {
	background: linear-gradient(to bottom, #000000 0%, #000066 100%);
	background-size: 3000px 900px;
	padding-top: 40px;
}

h2, h5 {
	text-align: center;
}

div.abc {
	margin-top: 130px;
}

form {
	border-radius: 2px;
}
</style>

</head>
<body>

	<div class="container-fluid">
		<div class="col-md-4 offset-md-4">


			<div class="abc">
				<div class="card">

					<div class="card-body">
						<h1 class="text-center text-primary">
							<img src="images/esspl.png" class="d-block w-100"
								height="150" style="height: 100;" alt="...">
							<!-- <b>Login Here <svg xmlns="http://www.w3.org/2000/svg"
									width="40" height="40" viewBox="0 0 24 24">
									<path
										d="M8.612 2l1.55 1.548-4.224 4.12 9.291 9.291 4.222-4.12 1.549 1.549v-12.388h-12.388zm7.388 7c-1.104 0-2-.896-2-2s.896-2 2-2 2 .896 2 2-.896 2-2 2zm-4.271 7.271l-1.729 1.729h-2v2h-2v2h-6v-1.293l6.813-6.915-.657-.651-6.156 6.152v-2.293l6.219-6.203 5.51 5.474zm10.979-10.979l-.708.708v3.097l2-2.065-1.292-1.74z" /></svg></b> -->
						</h1>


						<form action="/dologin" method="post"
							style="background-color: white; padding-left: 15px; padding-right: 15px; padding-top: 20px; padding-bottom: 20px;">





							<!-- error message code -->

							<c:if test="${param.error != null}">
								<div class="alert alert-danger">Invalid username and
									password.</div>
							</c:if>

							<c:if test="${param.logout != null}">
								<div class="alert alert-success">When I wrote this code, only God and I understood what I did. Now only God knows.Thank God you successfully Logout !!! <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M8 9v-4l8 7-8 7v-4h-8v-6h8zm2-7v2h12v16h-12v2h14v-20h-14z"/></svg> </div>
							</c:if>






							<div class="form-group">
								<label for="email"><svg
										xmlns="http://www.w3.org/2000/svg" width="30" height="30"
										viewBox="0 0 24 24">
										<path
											d="M20.822 18.096c-3.439-.794-6.641-1.49-5.09-4.418 4.719-8.912 1.251-13.678-3.732-13.678-5.081 0-8.464 4.949-3.732 13.678 1.597 2.945-1.725 3.641-5.09 4.418-2.979.688-3.178 2.143-3.178 4.663l.005 1.241h10.483l.704-3h1.615l.704 3h10.483l.005-1.241c.001-2.52-.198-3.975-3.177-4.663zm-8.231 1.904h-1.164l-.91-2h2.994l-.92 2z" /></svg>
									<b>Username</b></label> <input type="text" name="username"
									class="form-control" id="email" placeholder="Enter username"
									style="margin-top: 9px;" name="email">
							</div>
							<div class="form-group">
								<label for="pwd" style="margin-top: 9px;"><svg
										xmlns="http://www.w3.org/2000/svg" width="30" height="30"
										viewBox="0 0 24 24">
										<path
											d="M12.451 17.337l-2.451 2.663h-2v2h-2v2h-6v-5l6.865-6.949c1.08 2.424 3.095 4.336 5.586 5.286zm11.549-9.337c0 4.418-3.582 8-8 8s-8-3.582-8-8 3.582-8 8-8 8 3.582 8 8zm-3-3c0-1.104-.896-2-2-2s-2 .896-2 2 .896 2 2 2 2-.896 2-2z" /></svg>
									<b>Password</b></label> <input type="password" name="password"
									class="form-control" id="pwd" placeholder="Enter password"
									style="margin-top: 9px;" name="pwd">
							</div>

							<br>

							<button type="submit" class="btn btn-success"
								style="width: 430px;">
								<b>Submit</b>
							</button>
							
						</form>


						<h5 style="font-size: medium; color: black;">
							<b> Not have an account ? <a href="/register">Send Request here </b><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-balloon-heart-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M8.49 10.92C19.412 3.382 11.28-2.387 8 .986 4.719-2.387-3.413 3.382 7.51 10.92l-.234.468a.25.25 0 1 0 .448.224l.04-.08c.009.17.024.315.051.45.068.344.208.622.448 1.102l.013.028c.212.422.182.85.05 1.246-.135.402-.366.751-.534 1.003a.25.25 0 0 0 .416.278l.004-.007c.166-.248.431-.646.588-1.115.16-.479.212-1.051-.076-1.629-.258-.515-.365-.732-.419-1.004a2.376 2.376 0 0 1-.037-.289l.008.017a.25.25 0 1 0 .448-.224l-.235-.468ZM6.726 1.269c-1.167-.61-2.8-.142-3.454 1.135-.237.463-.36 1.08-.202 1.85.055.27.467.197.527-.071.285-1.256 1.177-2.462 2.989-2.528.234-.008.348-.278.14-.386Z"/>
</svg>
			
							</a>
						</h5>
					</div>

				</div>
			</div>
		</div>
	</div>



	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>