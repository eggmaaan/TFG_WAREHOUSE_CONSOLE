package service;

import beans.Warehouse;
import dao.WarehouseDAO;
import interfaces.IWarehouseDAO;
import interfaces.IWarehouseSERVICE;
import util.TransaccionManager;

import java.util.List;

public class WarehouseSERVICE implements IWarehouseSERVICE {
    @Override
    public Warehouse findById(int id) {
        Warehouse aux = null;
        TransaccionManager tm= null;
        try{

            tm = new TransaccionManager();
            IWarehouseDAO dao = tm.getWarehouseDAO();
            aux = dao.findById(id);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }

        return aux;
    }

    @Override
    public void addWarehouse(Warehouse newWarehouse) {

        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IWarehouseDAO dao = tm.getWarehouseDAO();
            dao.addWarehouse(newWarehouse);
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }


    }

    @Override
    public List<Warehouse> listAllWarehouses() {
        List<Warehouse> warehouses = null;
        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IWarehouseDAO dao = tm.getWarehouseDAO();
            warehouses = dao.listAllWarehouses();
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

        return warehouses;
    }

    @Override
    public int getFirstId() {
        int id = 0;

        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IWarehouseDAO dao = tm.getWarehouseDAO();
            id = dao.getFirstId();
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

        return id;
    }

}
