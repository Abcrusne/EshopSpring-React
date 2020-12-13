package it.akademija.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.model.CartProduct;

@Repository
public class InMemoryCartProductDAO implements CartProductDAO {

	private final Map<String, List<CartProduct>> productsByUsername = new HashMap<>();

	@Override
	public List<CartProduct> getCartProducts(String username) {
		if (!(productsByUsername.containsKey(username))) {
			productsByUsername.put(username, new CopyOnWriteArrayList<>());
			return Collections.unmodifiableList(productsByUsername.get(username));
		} else {
			return Collections.unmodifiableList(productsByUsername.get(username));
		}
	}

	@Override
	public void addCartProduct(String username, CartProduct cartProduct) {

		productsByUsername.get(username).add(cartProduct);
	}

	@Override
	public void deleteCartProduct(String username, int id) {
		productsByUsername.get(username).remove(id);
	}

}
