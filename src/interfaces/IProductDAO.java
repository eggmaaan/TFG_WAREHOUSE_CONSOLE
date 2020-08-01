package interfaces;


import beans.Product;

import java.util.List;


public interface IProductDAO {

    public Product findById(int id);
    public void addProduct(Product newProduct);
    public void updateProduct(Product upProduct);
    public void deleteProduct(int id);
    public List<Product> listAllProducts();


}
