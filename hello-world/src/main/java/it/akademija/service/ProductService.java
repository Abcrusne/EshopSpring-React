package it.akademija.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBProductDao;
import it.akademija.dao.ProductDetailsDao;
import it.akademija.entities.Product;
import it.akademija.entities.ProductDetails;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.ProductFromService;

@Service("productService")
public class ProductService {

	@Autowired
	private DBProductDao dbProductDao;

	@Autowired
	private ProductDetailsDao productDetailsDao;

	public ProductDetailsDao getProductDetailsDao() {
		return productDetailsDao;
	}

	public void setProductDetailsDao(ProductDetailsDao productDetailsDao) {
		this.productDetailsDao = productDetailsDao;
	}

	public DBProductDao getDbProductDao() {
		return dbProductDao;
	}

	public void setDbProductDao(DBProductDao dbProductDao) {
		this.dbProductDao = dbProductDao;
	}

	@Transactional(readOnly = true)
	public Set<ProductFromService> getProducts() {
		return dbProductDao.findAll().stream()
				.map(productDB -> new ProductFromService(productDB.getTitle(), productDB.getProductDetails().getImage(),
						productDB.getProductDetails().getDescription(), productDB.getPrice(), productDB.getQuantity(),
						productDB.getId()))
				.collect(Collectors.toSet());

	}

	@Transactional
	public ProductFromService getProduct(Long id) {
		var product = dbProductDao.getProduct(id);
		return new ProductFromService(product.getTitle(), product.getProductDetails().getImage(),
				product.getProductDetails().getDescription(), product.getPrice(), product.getQuantity(),
				product.getId());
	}

	@Transactional
	public void createProduct(CreateProductCommand product) {
		var product1 = new Product(product.getTitle(), product.getPrice(), product.getQuantity());
		var productDetails = new ProductDetails(product.getImage(), product.getDescription());
		var issaugotasProductDetails = productDetailsDao.save(productDetails);
		product1.setProductDetails(issaugotasProductDetails);
		dbProductDao.save(product1);
		// dbProductDao.createProduct(new Product(product.getTitle(),
		// product.getPrice(), product.getQuantity(), new
		// ProductDetails(product.getImage(), product.getDescription())));

	}

	@Transactional
	public void updateProduct(ProductFromService product) {
		var product1 = new Product(product.getTitle(), product.getPrice(), product.getQuantity());
		var productDetails = new ProductDetails(product.getImage(), product.getDescription());
		product1.setId(product.getId());
		productDetails.setId(product.getId());
		var issaugotasProductDetails = productDetailsDao.save(productDetails);
		product1.setProductDetails(issaugotasProductDetails);
//		dbProductDao.save(product1);
		dbProductDao.updateProduct(product1);
	}

	@Transactional
	public void deleteProduct(Long id) {
		dbProductDao.deleteById(id);
	}

//	void deleteById(Long id);
//
//	Product findById(Long id);

}
