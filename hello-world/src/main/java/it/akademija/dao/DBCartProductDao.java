package it.akademija.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.akademija.entities.CartProduct;
import it.akademija.entities.Product;

@Repository
public interface DBCartProductDao extends JpaRepository<CartProduct, String>, CartProductDAO {

	// @Query(select * from CartProduct c where c.username=(select u from User u
	// where
	// u.username = :username))
	default Set<Product> getCartProducts(String username) {
		if (this.findById(username).isEmpty()) {
			this.save(new CartProduct(username));
			return this.findById(username).get().getProducts();
		} else {
			return this.findById(username).get().getProducts();
		}

		// findCartProductsByUserUsername(String username)
	}

	default CartProduct addCartProduct(String username, Product product) {
		var cart = this.findById(username).get();
		var productsInCart = cart.getProducts();
		productsInCart.add(product);
		cart.setProducts(productsInCart);
		return this.save(cart);

	}

	// select u from User u where u.username = :username
	// @Query("delete c from CartProduct c where c.id = :id")
	default CartProduct deleteCartProduct(String username, Product product) {
		var cart = this.findById(username).get();
		var productsInCart = cart.getProducts();
		productsInCart.remove(product);
		cart.setProducts(productsInCart);
		return this.save(cart);
		// this.deleteCartProductByIdAndUserUsername(username, id);

	}

	default CartProduct getCartByUsername(String username) {
		return this.findById(username).orElse(null);

	}

	// public void deleteCartProductByIdAndUserUsername(String username, int id);

	// List<CartProduct> findCartProductsByUserUsername(String username);
}
