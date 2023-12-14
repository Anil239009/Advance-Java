package Tester;

import static Utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

public class GetProductByStock {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter your Product Stock : ");
			ProductDaoImpl dao = new ProductDaoImpl();
			dao.getProductByStock(sc.nextInt()).forEach(System.out::println);
		}

	}

}
