package it.akademija.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.entities.Product;

//@Repository
public interface DBProductDao extends JpaRepository<Product, Long>, ProductDAO {

	default Set<Product> getProducts() {
		return (Set<Product>) this.findAll();
	}

	default Product getProduct(Long id) {
		return this.findById(id).orElse(null);

	}

	default void createProduct(Product product) {
		this.save(product);
	}

//	@Modifying
//	@Query("update Product p SET p =:product"
	default void updateProduct(Product product) {
		this.save(product);

	}

	default void deleteProduct(Long id) {
		this.deleteById(id);
	}

//	@Modifying
//	@Query("delete p from Product p where p.id = :id")
//	void deleteById(Long id);

//	@Modifying
//	@Query("select p from Product p where p.id = :id")
//	Product findOneProductById(Long id);

	// Product getOne(Long id);
}
