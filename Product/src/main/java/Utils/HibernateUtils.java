package Utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
//	to provide singleton,immutable,inherently thread safe, heavy weight session factory
private  static SessionFactory factory;

static {
	System.out.println("Inside static block");
	factory=new Configuration()//empty configuration
			.configure()//confi object populated from hibernate.cfg.xml
			.buildSessionFactory();//attach build factory
}
// getters

public static SessionFactory getFactory() {
	return factory;
}


}
