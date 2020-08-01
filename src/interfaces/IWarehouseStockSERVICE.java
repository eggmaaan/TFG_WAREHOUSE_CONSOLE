package interfaces;

import beans.WarehouseStock;

import java.util.List;


public interface IWarehouseStockSERVICE {

    public WarehouseStock findById(int id);
    public void addWarehouse(WarehouseStock newWarehouseStock);
    public List<WarehouseStock> listAllWarehouseStocks();
    public int getFirstId();

}
