package it.akademija.model;

import java.math.BigDecimal;

public class ProductFromService {

	private String title;
	private String image;
	private String description;
	private BigDecimal price;
	private int quantity;
	private Long id;

	public ProductFromService() {
		super();
	}

	public ProductFromService(String title, String image, String description, BigDecimal price, int quantity, Long id) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
