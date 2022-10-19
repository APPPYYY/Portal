<div class="row fst-italic text-uppercase">
<div class="col-md-12">
<div class="card bg-light text-dark">
<div class="card-header">
<h2 class="text-center bg-dark text-white">--ALL CATEGORY--</h2>
</div>
<div class="card-body">
<table class="table table-striped">
<thead>
<tr>
<th>Name</th>
<th>Description</th>

</tr>
</thead>
<tbody>
<c:forEach var="category" items="${category}">
<tr>
<td>${category.cname}</td>
<td>${category.cdescription}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>


</div>
</div>