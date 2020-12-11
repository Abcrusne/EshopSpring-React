package it.akademija.dao;

import java.util.Set;

import it.akademija.model.CartProduct;

public interface CartProductDAO {

	Set<CartProduct> getCartProducts(String username);

	void addCartProduct(String username, CartProduct cartProduct);

	Set<CartProduct> deleteCartProduct(String username, int id);

}
