package it.akademija.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.akademija.entities.Product;

@RestController
@ApiOperation(value = "RestService")
public class RestService {

	@Autowired
	private Set<Product> products;

	@RequestMapping("/productsCollection")
	public Set<Product> getProductsCollection() {
		return products;
	}

}
