package it.akademija.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBCartProductDao;
import it.akademija.model.CartProduct;

public class CartProductService {

	@Autowired
	private DBCartProductDao dbCartProductDao;
	@Autowired
	private final Map<String, List<CartProduct>> productsByUsername = new HashMap<>();

	public DBCartProductDao getDbCartProductDao() {
		return dbCartProductDao;
	}

	public void setDbCartProductDao(DBCartProductDao dbCartProductDao) {
		this.dbCartProductDao = dbCartProductDao;
	}

	@Transactional(readOnly = true)
	public List<CartProduct> getCartProducts(String username) {
		if (!(productsByUsername.containsKey(username))) {
			productsByUsername.put(username, new CopyOnWriteArrayList<>());
			return Collections.unmodifiableList(productsByUsername.get(username));
		} else {
			return Collections.unmodifiableList(productsByUsername.get(username));
		}
	}

	@Transactional
	public void addCartProduct(String username, CartProduct cartProduct) {
		productsByUsername.get(username).add(cartProduct);
	}

	@Transactional
	public void deleteCartProduct(String username, int id) {
		productsByUsername.get(username).remove(id);
	}

}
