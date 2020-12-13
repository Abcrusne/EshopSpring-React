package it.akademija.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBProductDao;
import it.akademija.model.Product;

@Service
public class ProductService {

	@Autowired
	private DBProductDao dbProductDao;

	public DBProductDao getDbProductDao() {
		return dbProductDao;
	}

	public void setDbProductDao(DBProductDao dbProductDao) {
		this.dbProductDao = dbProductDao;
	}

	@Transactional
	public Set<Product> getProducts() {
		return dbProductDao.getProducts();
	}

	@Transactional
	public Product getProduct(Long id) {
		return dbProductDao.getOne(id);
	}

	@Transactional
	public void addProduct(Product product) {
		dbProductDao.addProduct(product);

	}

	@Transactional
	public void updateProduct(Product product) {
		dbProductDao.updateProduct(product);
	}

	@Transactional
	public void deleteProduct(Long id) {
		dbProductDao.deleteById(id);
	}

//	void deleteById(Long id);
//
//	Product findById(Long id);

}
