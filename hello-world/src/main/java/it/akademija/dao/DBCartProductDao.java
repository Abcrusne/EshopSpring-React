package it.akademija.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.model.CartProduct;

public interface DBCartProductDao extends JpaRepository<CartProduct, Integer>, CartProductDAO {

	default List<CartProduct> getCartProducts(String username) {
		return this.findAll();
	}

	default void addCartProduct(String username, CartProduct cartProduct) {

	}

	default void deleteCartProduct(String username, int id) {

	}
}
