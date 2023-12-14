package Dao;

import org.hibernate.*;
import pojos.Product;
import pojos.ProductCategory;

import static Utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Enumerated;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addNewProduct(Product product) {
//		1.Create session object
		String msg="Product not added having some issue...!";
		Session session=getFactory().getCurrentSession();
//		current factory will generate one session id for multiple 
//		times calling the same session 
//		in other side get session will generate multiple session id per call
		Transaction tx=session.beginTransaction();
		try {
			session.save(product);
//			Persist the given transient instance, first assigning a generated identifier. 
//			(Orusing the current value of the identifier property if the assignedgenerator is used.) 
//			This operation cascades to associated instances if theassociation is mapped with cascade="save-update"
			tx.commit();
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	public List<Product>ListAllProducts(){
//		1.Create session object
		List<Product> product=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="Select p from Product p";
		try {
			product=session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return product;	
	}
	
	public List<Product> getProductByCategory(ProductCategory category){
		List<Product> products=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="Select p from Product p where p.category=:cat";
		try {
			products=session.createQuery(jpql, Product.class)
					.setParameter("cat", category).getResultList();
			tx.commit();
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return products;
	}
	public List<Product>getProductByStock(int stock){
		List<Product>list=null;//creating empty list to store product it will be created by Hibernate
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="select p from Product p where p.stock>:pstock";
		try {
			list = session.createQuery(jpql, Product.class)
					.setParameter("pstock", stock).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
				throw e;
			}
		}
		return list;
	}
	public List<Product> getProductBySpecifiedDate(LocalDate manufacturingDate){
		List<Product> products=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="Select new pojos.Product(productId,name,price) from Product p where p.manufacturingDate>:date";
		try {
			products=session.createQuery(jpql, Product.class)
					.setParameter("date", manufacturingDate).getResultList();
			tx.commit();
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return products;
	}
	 public String updateProductPrice(Integer productId,double priceOffset) {
		 String msg="Price updated Failed...!";
		 Product p=null;
			Session session=getFactory().getCurrentSession();
			Transaction tx=session.beginTransaction();
			String jpql="Select new pojos.Product(productId,name,price) from Product p where p.manufacturingDate>:date";
			try {
				p=session.get(Product.class, productId);
				if(p!=null) {
					p.setPrice(p.getPrice()+priceOffset);
					msg="Product updated successfully..!";
				}
				tx.commit();//session.flush-->
				//auto dirty checking--> updated entity-->
				//DML: update
				//session.close()-->L1 cache is destroyed and pooled out
				//db connection return to pool
			}catch(RuntimeException e){
				if(tx!=null)
					tx.rollback();
				throw e;
			}
			//product: detached from L1 cache
			//
			
			return msg;
	 }
}
