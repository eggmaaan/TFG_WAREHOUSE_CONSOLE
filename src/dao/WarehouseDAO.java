package dao;

import beans.Warehouse;
import interfaces.IWarehouseDAO;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class WarehouseDAO implements IWarehouseDAO {

    private Session session;

    public WarehouseDAO(Session session){
        this.session = session;

    }

    @Override
    public Warehouse findById(int id) {
        return session.get(Warehouse.class, id);
    }

    @Override
    public void addWarehouse(Warehouse newWarehouse) {

        session.save(newWarehouse);

    }

    @Override
    public List<Warehouse> listAllWarehouses() {
        Query query = (Query)session.createNativeQuery("Select ID, NAME, LOCATION from WAREHOUSE", Warehouse.class);
        List<Warehouse> warehouses = query.getResultList();

        return warehouses;
    }

    @Override
    public int getFirstId() {
        int id;
        Query query = (Query)session.createNativeQuery("Select MIN(ID) as ID, NAME, LOCATION from WAREHOUSE", Warehouse.class);
        Warehouse war = (Warehouse) query.getSingleResult();
        return id = war.getId();

    }


}
