package it.akademija.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.akademija.model.Product;

@Repository
public class InMemoryProductDAO implements ProductDAO {

	@Autowired
	private List<Product> products = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	@Override
	public Product getProduct(Long id) {
		return products.stream().filter(product -> product.getId() == id).findAny().get();
	}

	@Override
	public void addProduct(Product product) {
		products.add(product);

	}

	@Override
	public void updateProduct(Product product) {
		Product productToUpdate = getProduct(product.getId());
		productToUpdate.setTitle(product.getTitle());
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setImage(product.getImage());
		productToUpdate.setPrice(product.getPrice());
		productToUpdate.setQuantity(product.getQuantity());

	}

	@Override
	public void deleteProduct(Long id) {
		Product productToRemove = getProduct(id);
		products.remove(productToRemove);

	}

}
