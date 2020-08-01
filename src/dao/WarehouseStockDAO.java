package dao;

import beans.Warehouse;
import beans.WarehouseStock;
import interfaces.IWarehouseStockDAO;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class WarehouseStockDAO implements IWarehouseStockDAO {

    private Session session;

    public WarehouseStockDAO(Session session){
        this.session = session;

    }

    @Override
    public WarehouseStock findById(int id) {

        return session.get(WarehouseStock.class, id);

    }

    @Override
    public void addWarehouseStock(WarehouseStock newWarehouseStock) {
        session.save(newWarehouseStock);
    }

    @Override
    public List<WarehouseStock> listAllWarehouseStocks() {
        Query query = (Query)session.createNativeQuery("Select ID, ID_WAREHOUSE, ID_PRODUCT, STOCK from WAREHOUSESTOCK", WarehouseStock.class);
        List<WarehouseStock>  warehouseStocks = query.getResultList();
        return warehouseStocks;
    }

    @Override
    public int getFirstId() {
        int id;
        Query query = (Query)session.createNativeQuery("Select MIN(ID) as ID ,ID_WAREHOUSE, ID_PRODUCT, STOCK from WAREHOUSESTOCK", WarehouseStock.class);
        WarehouseStock warStock = (WarehouseStock) query.getSingleResult();
        return id = warStock.getId();
    }


}
