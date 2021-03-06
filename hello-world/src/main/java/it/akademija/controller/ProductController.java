package it.akademija.controller;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.ProductFromService;
import it.akademija.service.ProductService;

@RestController
@Api(value = "products")
@RequestMapping(value = "/api/products")
public class ProductController {

//	private final ProductDAO productDao;
//
//	@Autowired
//	public ProductController(ProductDAO productDao) {
//		this.productDao = productDao;
//	}

	@Autowired
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products")
	public Set<ProductFromService> getProducts() {
//		return productService.getProducts().stream()
//				.map(productIsServiso -> new ProductFromService(productIsServiso.getTitle(),
//						productIsServiso.getImage(), productIsServiso.getDescription(), productIsServiso.getPrice(),
//						productIsServiso.getQuantity(),
//						productIsServiso.getId()))
//				.collect(Collectors.toSet());
		return productService.getProducts();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get product", notes = "Returns product with specified id")
	public ProductFromService getProduct(@PathVariable final Long id) {
		return productService.getProduct(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create product", notes = "Creates new product")
	public void createProduct(@RequestBody final CreateProductCommand cmd) {
		productService.createProduct(cmd);

//		String title = cmd.getTitle();
//	String description = cmd.getDescription();
//		String image = cmd.getImage();
//		BigDecimal price = cmd.getPrice();
//		int quantity = cmd.getQuantity();
//		var product = new ProductFromService(title, description, image, price, quantity, id);
//		productService.saveProduct(product);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Update product", notes = "Updates product with specified id")
	public void updateProduct(@PathVariable Long id, @RequestBody CreateProductCommand cmd) {

		String title = cmd.getTitle();
		String description = cmd.getDescription();
		String image = cmd.getImage();
		BigDecimal price = cmd.getPrice();
		int quantity = cmd.getQuantity();
		var product = new ProductFromService(title, description, image, price, quantity, id);
		productService.updateProduct(product);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "Deletes product with specified id")
	public void deleteProduct(@PathVariable final Long id) {
		productService.deleteProduct(id);
	}

}
