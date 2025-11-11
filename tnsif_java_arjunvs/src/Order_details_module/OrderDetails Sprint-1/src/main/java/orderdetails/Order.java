package orderdetails;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String customerName;
    private String product;
    private int quantity;

    // Generate getter and setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Generate constructors
    public Order() {
        super();
    }

    public Order(String customerName, String product, int quantity, int orderId) {
        super();
        this.orderId=orderId;
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
    }

    // Generate toString()
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", product=" + product + ", quantity=" + quantity + "]";
    }
}
