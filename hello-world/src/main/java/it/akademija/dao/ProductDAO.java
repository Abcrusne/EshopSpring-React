package it.akademija.dao;

import java.util.Set;

import it.akademija.model.Product;

public interface ProductDAO {

	Set<Product> getProducts();

	Product getProduct(Long id);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long id);

}
