package pojos;

import javax.persistence.*;
import java.time.LocalDate;

//product table : id, name, category,price,stock,description manufacturing date
@Entity // class level runtime annotation to tell hibernate following class is an entity
//to be managed by hibernate
@Table(name = "products")
public class Product {
	@Id // constraint primary key
		// specifies automatic generation of primary key ():default startgey :AUTO
		// replaced by identity=> auto increment constraint will be added in column(BEST
		// suitable for MYSQL DB)

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;


	@Column(length = 100, nullable = false) // varchar(100)
	private String name;// not null constraint
//by default col type: int to store enum ordinal, to replace it by 
	@Enumerated(EnumType.STRING) // varchar
	@Column(length = 20)
	private ProductCategory category;
	private double price;
	private int stock;
	@Column(name = "product_desc", length = 200)
	private String productDesc;
	@Column(name = "manufacture_date")
	private LocalDate manufacturingDate;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public Product(String name, ProductCategory category, double price, int stock, String productDesc,
			LocalDate manufacturingDate) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.productDesc = productDesc;
		this.manufacturingDate = manufacturingDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + ", productDesc=" + productDesc + ", manufacturingDate=" + manufacturingDate
				+ "]";
	}

}
