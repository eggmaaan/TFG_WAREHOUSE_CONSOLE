package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {

    public SessionFactory connect() {

        SessionFactory sessionFactory = null;
        try{
            final StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
            sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();

        }catch (Exception e){
            e.printStackTrace();
        }

        return sessionFactory;
    }

}
