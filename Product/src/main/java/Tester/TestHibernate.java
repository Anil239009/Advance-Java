package Tester;
import org.hibernate.SessionFactory;

import static Utils.HibernateUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			System.out.println("Hibernate booting"+sf);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
