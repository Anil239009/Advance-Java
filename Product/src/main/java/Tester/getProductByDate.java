package Tester;

import static Utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

public class getProductByDate {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory();Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter your Product Date : ");
			ProductDaoImpl dao = new ProductDaoImpl();
			dao.getProductBySpecifiedDate(LocalDate.parse(sc.next())).forEach(p->System.out.println(p.getProductId()+" "+p.getName()+""+p.getPrice()));

		}

	}

}
