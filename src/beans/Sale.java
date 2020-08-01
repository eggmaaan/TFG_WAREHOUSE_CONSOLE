package beans;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="SALE")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_WAREHOUSE")
    private Warehouse warehouse;

    @Column(name="SALE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar saleDate;

    public Sale() {

    }

    public Sale(Product product, Warehouse warehouse,  Calendar saleDate) {
        this.warehouse = warehouse;
        this.product = product;
        this.saleDate = saleDate;
    }

    public Sale(int id, Product product, Warehouse warehouse, Calendar saleDate) {
        this.id = id;
        this.product = product;
        this.warehouse = warehouse;
        this.saleDate = saleDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Calendar getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", product=" + product +
                ", warehouse=" + warehouse +
                ", saleDate=" + saleDate +
                '}';
    }
}
