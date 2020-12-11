package it.akademija.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import it.akademija.model.CartProduct;

@Repository
public class InMemoryCartProductDAO implements CartProductDAO {

	private final Map<String, Set<CartProduct>> productsByUsername = new ConcurrentHashMap<>();

	@Override
	public Set<CartProduct> getCartProducts(String username) {
		return productsByUsername.get(username);
	}

	@Override
	public void addCartProduct(String username, CartProduct cartProduct) {
		if (!productsByUsername.containsKey(username)) {
			productsByUsername.put(username, new HashSet<>());
		}
		productsByUsername.get(username).add(cartProduct);
	}

	@Override
	public Set<CartProduct> deleteCartProduct(String username, int id) {
		Set<CartProduct> existingCartProducts = productsByUsername.get(username);
		existingCartProducts = existingCartProducts.stream().filter(c -> c.getId() != id).collect(Collectors.toSet());
		productsByUsername.put(username, existingCartProducts);
		return getCartProducts(username);
	}

}
