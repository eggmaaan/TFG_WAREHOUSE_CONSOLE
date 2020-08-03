package util;

import dao.*;
import interfaces.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransaccionManager {

    private Session session;

    private SessionFactory sessionFactory;

    public TransaccionManager(){
        Connection connection = new Connection();
        sessionFactory = connection.connect();
        System.out.println("Conectado");
        session = sessionFactory.openSession();
        session.beginTransaction();

    }

    public void closeConnectionOK(){
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void closeConnectionFail(){
        session.getTransaction().rollback();
        session.close();
        sessionFactory.close();
    }

    public IWarehouseDAO getWarehouseDAO(){
        return new WarehouseDAO(session);
    }
    public IWarehouseStockDAO getWarehouseStockDAO(){
        return new WarehouseStockDAO(session);
    }
    public IProductDAO getProductDAO(){
        return new ProductDAO(session);
    }
    public ISaleDAO getSaleDAO(){
        return new SaleDAO(session);
    }
}
