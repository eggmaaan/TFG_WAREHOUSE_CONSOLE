package interfaces;

import beans.Product;
import beans.Warehouse;
import beans.WarehouseStock;

import java.util.List;


public interface IWarehouseStockSERVICE {

    public WarehouseStock findById(int id);
    public void addWarehouse(WarehouseStock newWarehouseStock);
    public List<WarehouseStock> listAllWarehouseStocks();
    public WarehouseStock findByWarAndPr(Warehouse warehouse, Product product);
    public int getFirstId();

}
