<div class="container-fluid">
		<div class="row gg">

			<nav class="navbar navbar-expand-lg navbar navbar-dark bg-danger fst-italic text-uppercase ">
				<a class="navbar-brand fst-italic text-uppercase" href="/"><b>SpringBoot</b></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active" id="home"><a class="nav-link" href="/home">Home
								
						</a></li>
						<li class="nav-item" id="about"><a class="nav-link" href="/about">About</a>
						</li>
						<li class="nav-item" id="products"><a class="nav-link" href="/product">Products</a>
						</li>
						<li class="nav-item"><a class="nav-link " href="/category">Category</a>
						</li>
						<li class="nav-item" id="about"><a class="nav-link" href="/register">Request</a>
						</li>
						<li class="nav-item"><a class="nav-link disabled" href="javascript:void(0)">Contact</a>
						</li>
					</ul>
				</div>
				<form action="/logout" method="post">
				<input type="submit" class="btn btn-danger fst-italic fs-5 fw-bold" value="Logout "  />
				</form>
			</nav>
		</div>
	</div>