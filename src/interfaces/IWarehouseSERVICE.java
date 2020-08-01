package interfaces;

import beans.Warehouse;

import java.util.List;


public interface IWarehouseSERVICE {

    public Warehouse findById(int id);
    public void addWarehouse(Warehouse newWarehouse);
    public List<Warehouse> listAllWarehouses();
    public int getFirstId();

}
