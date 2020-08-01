package dao;

import beans.Sale;
import interfaces.ISaleDAO;
import org.hibernate.Session;

import java.util.List;

public class SaleDAO implements ISaleDAO {

    Session session = null;

    public SaleDAO(Session session){
        this.session = session;
    }

    @Override
    public Sale findById(int id) {
        return null;
    }

    @Override
    public void addSale(Sale newSale) {
        session.save(newSale);
    }

    @Override
    public List<Sale> listAllSales() {
        return null;
    }
}
