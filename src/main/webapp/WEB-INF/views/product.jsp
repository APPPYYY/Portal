<div class="row fst-italic text-uppercase">
<div class="col-md-12">
<div class="card bg-light text-dark">
<div class="card-header">
<h2 class="text-center bg-danger text-white">---ALL PRODUCTS---</h2>
</div>
<div class="card-body">
<table class="table table-striped">
<thead>
<tr>
<th>Name</th>
<th>Brand</th>
<th>Description</th>
<th>Price</th>
<th>Quantity</th>
</tr>
</thead>
<tbody>
<c:forEach var="products" items="${product}">
<tr>
<td>${products.name}</td>
<td>${products.brand}</td>
<td>${products.description}</td>
<td>${products.unitprice}</td>
<td>${products.quantity}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>


</div>
</div>