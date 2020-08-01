package interfaces;

import beans.WarehouseStock;

import java.util.List;


public interface IWarehouseStockDAO {

    public WarehouseStock findById(int id);
    public void addWarehouseStock(WarehouseStock newWarehouseStock);
    public List<WarehouseStock> listAllWarehouseStocks();
    public int getFirstId();

}
