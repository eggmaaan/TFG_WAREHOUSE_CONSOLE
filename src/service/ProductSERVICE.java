package service;

import beans.Product;
import interfaces.IProductDAO;
import interfaces.IProductSERVICE;
import util.TransaccionManager;

import java.util.List;

public class ProductSERVICE implements IProductSERVICE {
    @Override
    public Product findById(int id) {
        Product aux = null;
        TransaccionManager tm= null;
        try{

            tm = new TransaccionManager();
            IProductDAO dao = tm.getProductDAO();
            aux = dao.findById(id);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }

        return aux;
    }

    @Override
    public void addProduct(Product newProduct) {

        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IProductDAO dao = tm.getProductDAO();
            dao.addProduct(newProduct);
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }


    }

    @Override
    public List<Product> listAllProducts() {
        List<Product> Products = null;
        TransaccionManager tm = null;
        try{
            tm = new TransaccionManager();
            IProductDAO dao = tm.getProductDAO();
            Products = dao.listAllProducts();
            tm.closeConnectionOK();
        }catch(Exception e){
            tm.closeConnectionFail();
        }

        return Products;
    }
}
