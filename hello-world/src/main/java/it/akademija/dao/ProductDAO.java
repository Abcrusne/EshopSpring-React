package it.akademija.dao;

import java.util.List;

import it.akademija.model.Product;

public interface ProductDAO {

	List<Product> getProducts();

	Product getProduct(Long id);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long id);

}
