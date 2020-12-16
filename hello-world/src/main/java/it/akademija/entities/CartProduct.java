package it.akademija.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
//@Table(name = "cart_products")
public class CartProduct {

	@Id
	private String username;

	@ManyToMany(mappedBy = "carts")
	private Set<Product> products;

	public CartProduct() {
		this.products = new HashSet<>();
	}

	public CartProduct(String username) {
		this.username = username;
		this.products = new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
