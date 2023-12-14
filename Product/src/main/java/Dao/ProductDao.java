package Dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Enumerated;

import pojos.Product;
import pojos.ProductCategory;

public interface ProductDao {
//add a method to insert new product details
	String addNewProduct(Product product);
	
//add a mthod to display all product
	List<Product>ListAllProducts();
	
//Get product by specific category
	List<Product> getProductByCategory(ProductCategory category);
//Get product by by stock greater than 20
	List<Product>getProductByStock(int stock);
//Get Product id , name , price n stock for all the products manufactured after specific date.
	List<Product> getProductBySpecifiedDate(LocalDate manufacturingDate);
//update product price
	String updateProductPrice(Integer productId,double priceOffset);
	
}
