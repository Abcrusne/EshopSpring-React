package it.akademija.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

//@MappedSuperclass

//@Table(name = "products")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Product_Type")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private BigDecimal price;
	private int quantity;

	@OneToOne(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "productDetails_id")
	private ProductDetails productDetails;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "Product_Cart", joinColumns = @JoinColumn(name = "Product_ID"), inverseJoinColumns = @JoinColumn(name = "Cart_Owner"))
	private Set<CartProduct> carts;
	// @MapKey(name = "cartProductsByUsername")
	// private final Map<String, List<CartProduct>> userProducts = new HashMap<>();

	public Product() {
		super();
	}

	public Product(String title, BigDecimal price, int quantity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.carts = new HashSet<>();
	}

	public Product(String title, BigDecimal price, int quantity, ProductDetails productDetails) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = productDetails;
		this.carts = new HashSet<>();
	}

	public Set<CartProduct> getCarts() {
		return carts;
	}

	public void setCarts(Set<CartProduct> carts) {
		this.carts = carts;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (image == null) {
//			if (other.image != null)
//				return false;
//		} else if (!image.equals(other.image))
//			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", quantity=" + quantity
				+ ", productDetails=" + productDetails + "]";
	}

}
