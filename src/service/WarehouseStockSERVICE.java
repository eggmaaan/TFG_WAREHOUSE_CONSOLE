package service;

import beans.Warehouse;
import beans.WarehouseStock;
import interfaces.IWarehouseDAO;
import interfaces.IWarehouseSERVICE;
import interfaces.IWarehouseStockDAO;
import interfaces.IWarehouseStockSERVICE;
import util.TransaccionManager;

import java.util.List;

public class WarehouseStockSERVICE implements IWarehouseStockSERVICE {


    @Override
    public WarehouseStock findById(int id) {
        TransaccionManager tm = null;
        WarehouseStock warehouseStock = null;

        try{
            tm = new TransaccionManager();
            IWarehouseStockDAO dao = tm.getWarehouseStockDAO();
            warehouseStock = dao.findById(id);
            tm.closeConnectionOK();


        }catch(Exception e){
            tm.closeConnectionFail();
        }
        return warehouseStock;

    }

    @Override
    public void addWarehouse(WarehouseStock newWarehouseStock) {
        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IWarehouseStockDAO dao = tm.getWarehouseStockDAO();
            dao.addWarehouseStock(newWarehouseStock);
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

    }

    @Override
    public List<WarehouseStock> listAllWarehouseStocks() {

        List<WarehouseStock> warehouseStocks = null;
        TransaccionManager tm = null;

        try{
            tm = new TransaccionManager();
            IWarehouseStockDAO dao = tm.getWarehouseStockDAO();
            warehouseStocks = dao.listAllWarehouseStocks();
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

        return warehouseStocks;

    }

    @Override
    public int getFirstId() {
        int id = 0;
        TransaccionManager tm = null;

        try{
            tm = new TransaccionManager();
            IWarehouseStockDAO dao = tm.getWarehouseStockDAO();
            id = dao.getFirstId();
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

        return id;


    }


}
