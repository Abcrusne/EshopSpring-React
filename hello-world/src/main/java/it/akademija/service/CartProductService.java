package it.akademija.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBCartProductDao;
import it.akademija.dao.DBProductDao;
import it.akademija.entities.Product;
import it.akademija.model.CreateCartProductCommand;

@Service
public class CartProductService {

	@Autowired
	private DBCartProductDao dbCartProductDao;

	@Autowired
	private DBProductDao dbProductDao;

	public DBCartProductDao getDbCartProductDao() {
		return dbCartProductDao;
	}

	public void setDbCartProductDao(DBCartProductDao dbCartProductDao) {
		this.dbCartProductDao = dbCartProductDao;
	}

	@Transactional(readOnly = true)
	public Set<Product> getCartProducts(String username) {
		return dbCartProductDao.getCartProducts(username);

	}

	@Transactional
	public Set<Product> addCartProduct(String username, CreateCartProductCommand cmd) {

		var product = dbProductDao.getProduct(cmd.getId());
		var productsInCart = product.getCarts();
		productsInCart.add(dbCartProductDao.addCartProduct(username, product));
		product.setCarts(productsInCart);
		dbProductDao.updateProduct(product);
		return dbCartProductDao.getCartProducts(username);

	}

	@Transactional
	public Set<Product> deleteCartProduct(String username, Long id) {
		var product1 = dbProductDao.getProduct(id);
		var productsInCart = product1.getCarts();
		productsInCart.remove(dbCartProductDao.deleteCartProduct(username, product1));
		return dbCartProductDao.getCartProducts(username);
	}

//	@Transactional
//	public CartProduct getCartByUsername(String username) {
//		return null;
//
//	}

//	@Transactional(readOnly = true)
//	public List<CartProduct> getCartProducts(String username) {
////		if (!(productsByUsername.containsKey(username))) {
////			productsByUsername.put(username, new CopyOnWriteArrayList<>());
////			return Collections.unmodifiableList(productsByUsername.get(username));
////		} else {
////			return Collections.unmodifiableList(productsByUsername.get(username));
////		}
//		return dbCartProductDao.getCartProducts(username);
//	}

//	@Transactional
//	public void addCartProduct(String username, CartProduct cartProduct) {
//		// productsByUsername.get(username).add(cartProduct);
//		dbCartProductDao.addCartProduct(username, cartProduct);
//	}

//	@Transactional
//	public void deleteCartProduct(String username, int id) {
//		// productsByUsername.get(username).remove(id);
//		dbCartProductDao.deleteCartProduct(username, id);
//	}

}
//@Transactional
//
//public Set<CartProduct> getCartProducts(String username) {
//
//return cartProductDao.findByUsername(username);
//
//}
//
//
// 
//
// @Transactional
//
//public void addCartProduct(String username, CartProduct cartProduct) {
//
//Map<String, Set<CartProduct>> products = new HashMap<String, Set<CartProduct>>();
//
//if (!products.containsKey(username)) {
//
//products.put(username, new HashSet<>());
//
//}
//
// products.get(username).add(cartProduct);
