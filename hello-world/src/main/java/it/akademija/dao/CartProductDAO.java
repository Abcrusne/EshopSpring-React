package it.akademija.dao;

import java.util.List;

import it.akademija.model.CartProduct;

public interface CartProductDAO {

	List<CartProduct> getCartProducts(String username);

	void addCartProduct(String username, CartProduct cartProduct);

	void deleteCartProduct(String username, int id);

}
