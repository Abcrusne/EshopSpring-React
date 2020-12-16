package it.akademija.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private Long id;
	private String image;
	private String description;

	@OneToOne(mappedBy = "productDetails")
	private Product product;

	public ProductDetails() {
		super();
	}

	public ProductDetails(String image, String description) {
		super();

		this.image = image;
		this.description = description;

	}

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
