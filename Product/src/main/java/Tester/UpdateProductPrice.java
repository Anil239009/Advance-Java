package Tester;

import static Utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

public class UpdateProductPrice {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter your Product id and offset price : ");
			ProductDaoImpl dao = new ProductDaoImpl();
			System.out.println(dao.updateProductPrice(sc.nextInt(), sc.nextDouble()));
		}
	}
}
