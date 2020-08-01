package dao;

import beans.Product;
import interfaces.IProductDAO;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private Session session;

    public ProductDAO(Session session){
        this.session = session;

    }

    @Override
    public Product findById(int id) {
        return session.get(Product.class, id);
    }

    @Override
    public void addProduct(Product newProduct) {

        session.save(newProduct);

    }

    @Override
    public void updateProduct(Product upProduct) {

        session.update(upProduct);

    }

    @Override
    public void deleteProduct(int id) {

        session.delete(id);
    }

    @Override
    public List<Product> listAllProducts() {
        Query query = (Query)session.createNativeQuery("Select ID, NAME, PRICE from PRODUCTS", Product.class);
        List<Product> products = query.getResultList();

        return products;
    }
}
