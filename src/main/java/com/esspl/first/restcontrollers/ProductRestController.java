package com.esspl.first.restcontrollers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esspl.exception.ProductNotFoundException;
import com.esspl.first.model.Product;
import com.esspl.first.services.ProductService;
import com.esspl.first.util.FileUtil;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	@Autowired
	private FileUtil fileUtil;

	@GetMapping(value="/getproduct",headers = "subham=1")
	public MappingJacksonValue getProducts() {
		Iterable<Product> list = productService.getProduct();
		SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "brand");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("productfilter", sbpf);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
		// return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/getproductpagination")
	public MappingJacksonValue getProductsPagination(@RequestParam Integer pageNumber, Integer pageSize) {
		List<Product> list = productService.getProductPagination(pageNumber, pageSize);
		SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "brand");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("productfilter", sbpf);

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
		// return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/insertproduct")
	public ResponseEntity<String> saveProducts(@Valid @RequestBody Product product) {
		productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product Inserted Successfully .");
	}

	@GetMapping("/getproduct/{id}")
	public EntityModel<Product> getProductById(@PathVariable int id) {
		Optional<Product> opt = productService.getById(id);
		if (!opt.isPresent()) {
			throw new ProductNotFoundException("this product is not present or you entered a wrong product id :" + id);
		}

		EntityModel<Product> value = EntityModel.of(opt.get());
		WebMvcLinkBuilder wmlb = linkTo(methodOn(getClass()).getProducts());
		return value.add(wmlb.withRel("Go Back To All Products @iamsubham"));

		// return ResponseEntity.of(Optional.of(opt));

	}

	@GetMapping("/getproducts/{id}")
	public ResponseEntity<Optional<Product>> getProductByIds(@PathVariable int id) {
		Optional<Product> opt = productService.getById(id);
		if (!opt.isPresent()) {
			throw new ProductNotFoundException("this product is not present or you entered a wrong product id :" + id);
		}

		/*
		 * EntityModel<Product> value = EntityModel.of(opt.get()); WebMvcLinkBuilder
		 * wmlb = linkTo(methodOn(getClass()).getProducts()); return
		 * value.add(wmlb.withRel("Go Back To All Products @iamsubham"));
		 */

		/*
		 * SimpleBeanPropertyFilter sbpf =
		 * SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "brand");
		 * FilterProvider filterProvider = new
		 * SimpleFilterProvider().addFilter("productfilter", sbpf);
		 * 
		 * MappingJacksonValue mapping = new MappingJacksonValue(opt);
		 * mapping.setFilters(filterProvider); return mapping;
		 */
		return ResponseEntity.of(Optional.of(opt));

	}

	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<String> updateProducts(@RequestBody Product product, @PathVariable int id) {
		productService.updateProduct(product, id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product Updated Successfully .");
	}

	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Product> deleteProducts(@PathVariable int id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/*
	 * @GetMapping("/getstatus/{id}") public ResponseEntity<List<Product>>
	 * retriveProductByStatusAndCategoryId(@PathVariable boolean
	 * status,@PathVariable int id){ List<Product>
	 * p1=productService.getActiveProductByCategory(id); return
	 * ResponseEntity.of(Optional.of(p1)); }
	 */
	@GetMapping("/getactiveproduct/{id}")
	public ResponseEntity<Iterable<Product>> retriveStatusTrueByCategoryId(@PathVariable int id) {
		Iterable<Product> p1 = productService.getStatusTrueByCategoryId(id);
		return ResponseEntity.of(Optional.of(p1));

	}

	@DeleteMapping("/deleteproductbycatagory/{id}")
	public ResponseEntity<String> deleteByCategoryId(@PathVariable int id) {
		productService.deleteProductByCategoryId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All Product Of Category Is Deleted");
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Please select a file !");
		}
		if (!(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png"))) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Please give a proper format of file !");
		}
		if (fileUtil.uploadFile(file)) {
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images")
					.path(file.getOriginalFilename()).toUriString());
		}

		return ResponseEntity.ok("Hey Something Wrong Here !.");
	}

}
