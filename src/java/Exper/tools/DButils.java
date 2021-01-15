package Exper.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DButils {
    static Session session = null;
    static SessionFactory factory = null;

    static {
        Configuration config = new Configuration().configure();
        factory = config.buildSessionFactory();
    }

    public static Session getSession(){

        return factory.openSession();
    }

    public static Session getCurrentSession(){

        session = factory.getCurrentSession();
        return session;
    }

    public static void main(String[] args) {

    }
}
