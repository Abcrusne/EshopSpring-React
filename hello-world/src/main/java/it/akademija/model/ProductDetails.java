package it.akademija.model;

import javax.persistence.Id;
import javax.persistence.OneToOne;

public class ProductDetails {

	@Id
	private Long id;
	private String image;
	private String description;

	@OneToOne(mappedBy = "productDetails")
	private Product product;

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
