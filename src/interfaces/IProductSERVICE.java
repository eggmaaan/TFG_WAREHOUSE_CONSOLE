package interfaces;


import beans.Product;

import java.util.List;


public interface IProductSERVICE {

    public Product findById(int id);
    public void addProduct(Product newProduct);
    public List<Product> listAllProducts();


}
