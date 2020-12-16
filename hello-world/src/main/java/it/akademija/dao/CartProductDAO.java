package it.akademija.dao;

import java.util.Set;

import it.akademija.entities.CartProduct;
import it.akademija.entities.Product;

public interface CartProductDAO {

	Set<Product> getCartProducts(String username);

	CartProduct addCartProduct(String username, Product product);

	CartProduct deleteCartProduct(String username, Product product);

	CartProduct getCartByUsername(String username);

}
