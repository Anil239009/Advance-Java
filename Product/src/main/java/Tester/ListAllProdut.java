package Tester;

import static Utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

public class ListAllProdut {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory()) {
			ProductDaoImpl dao = new ProductDaoImpl();
			dao.ListAllProducts().forEach(System.out::println);

		}

	}

}
