package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.akademija.model.Product;

@RestController
@ApiOperation(value = "RestService")
public class RestService {

	@Autowired
	private List<Product> products;

	@RequestMapping("/productsCollection")
	public List<Product> getProductsCollection() {
		return products;
	}

}
