<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style>
.card {
	margin-top: 80px;
}
</style>

<div class="container-fluid">
<div class="row">
<div class="col-md-4">

</div>

<div class="col-md-4">





<div class="card text-white bg-dark">
<div class="card-body">
<h2 class="text-center fst-italic">Request Here</h2>
<sf:form action="/register" method="POST">



<!-- error message code -->

							<c:if test="${param.error != null}">
								<div class="alert alert-danger">Invalid username and
									password.</div>
							</c:if>

							<c:if test="${param.logout != null}">
								<div class="alert alert-success">When I wrote this code, only God and I understood what I did. Now only God knows.Thank God you successfully Logout !!! <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M8 9v-4l8 7-8 7v-4h-8v-6h8zm2-7v2h12v16h-12v2h14v-20h-14z"/></svg> </div>
							</c:if>



  <div class="mb-3">
    <label for="name" class="form-label">UserName</label>
    <input type="text" class="form-control" name="name" placeholder="Enter your username here !" id="exampleInputPassword1">
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" name="email" placeholder="Enter your email id here !" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text text-white">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Enter your password here !" id="exampleInputPassword1">
  </div>
  
 <button type="submit" class="btn btn-light"
								style="width: 400px;">
								<b>Request </b></button>
</sf:form>

</div>
</div>




</div>

<div class="col-md-4">

</div>

</div>
</div>