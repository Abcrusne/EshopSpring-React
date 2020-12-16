package it.akademija.dao;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.akademija.entities.Product;

@Repository
public class InMemoryProductDAO implements ProductDAO {

	@Autowired
	private Set<Product> products;

	@Override
	public Set<Product> getProducts() {
		return Collections.unmodifiableSet(products);
	}

	@Override
	public Product getProduct(Long id) {
		return products.stream().filter(product -> product.getId() == id).findAny().get();
	}

	@Override
	public void createProduct(Product product) {
		products.add(product);

	}

	@Override
	public void updateProduct(Product product) {
		Product productToUpdate = getProduct(product.getId());
		productToUpdate.setTitle(product.getTitle());
		// productToUpdate.setDescription(product.getProductDetails().getDescription());
		// productToUpdate.setImage(product.getProductDetails().getImage());
		productToUpdate.setPrice(product.getPrice());
		productToUpdate.setQuantity(product.getQuantity());

	}

	@Override
	public void deleteProduct(Long id) {
		Product productToRemove = getProduct(id);
		products.remove(productToRemove);

	}

}
