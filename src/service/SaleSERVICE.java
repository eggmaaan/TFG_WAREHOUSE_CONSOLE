package service;

import beans.Sale;
import interfaces.ISaleDAO;
import interfaces.ISaleSERVICE;
import util.TransaccionManager;

import java.util.List;

public class SaleSERVICE implements ISaleSERVICE {
    @Override
    public Sale findById(int id) {
        return null;
    }

    @Override
    public void addSale(Sale newSale) {
        TransaccionManager tm = null;

        try{
            tm = new TransaccionManager();
            ISaleDAO dao = tm.getSaleDAO();
            dao.addSale(newSale);
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }


    }

    @Override
    public List<Sale> listAllSales() {
        return null;
    }
}
