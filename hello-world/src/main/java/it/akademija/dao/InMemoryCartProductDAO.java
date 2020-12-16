package it.akademija.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.entities.CartProduct;
import it.akademija.entities.Product;

@Repository
public class InMemoryCartProductDAO implements CartProductDAO {

	private final Map<String, List<Product>> userProducts = new HashMap<>();

	@Override
	public Set<Product> getCartProducts(String username) {
		if (!(userProducts.containsKey(username))) {
			userProducts.put(username, new CopyOnWriteArrayList<>());
			return (Set<Product>) Collections.unmodifiableList(userProducts.get(username));
		} else {
			return (Set<Product>) Collections.unmodifiableList(userProducts.get(username));
		}
	}

	@Override
	public CartProduct addCartProduct(String username, Product cartProduct) {
		userProducts.get(username).add(cartProduct);
		return null;
	}

	@Override
	public CartProduct deleteCartProduct(String username, Product product) {
		userProducts.get(username).remove(product.getId());

		return null;

	}

	@Override
	public CartProduct getCartByUsername(String username) {
		return (CartProduct) userProducts.get(username);
		// arba pakeisti metoda kad returnintu Lista
	}

}
