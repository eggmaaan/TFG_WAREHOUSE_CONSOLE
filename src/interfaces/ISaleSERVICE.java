package interfaces;

import beans.Sale;

import java.util.List;


public interface ISaleSERVICE {

    public Sale findById(int id);
    public void addSale(Sale newSale);
    public List<Sale> listAllSales();

}
