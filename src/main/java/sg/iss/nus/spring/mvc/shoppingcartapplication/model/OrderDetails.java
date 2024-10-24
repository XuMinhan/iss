package sg.iss.nus.spring.mvc.shoppingcartapplication.model;

import jakarta.persistence.*;
/**
 *
 * @author Ding Zihe
 *
 */
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @EmbeddedId
    private OrderDetailsId id = new OrderDetailsId();

    @ManyToOne
    @MapsId("orderId")  // 指定与 OrderDetailsId 中的 orderId 关联
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")  // 指定与 OrderDetailsId 中的 productId 关联
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    // Constructors, getters and setters
    public OrderDetails() {}

//    public OrderDetails(Order order, Product product, int quantity, int totalPrice) {
//        this.id = new OrderDetailsId(order.getId(), product.getProductId());
//        this.order = order;
//        this.product = product;
//        this.quantity = quantity;
//        this.totalPrice = totalPrice;
//    }

    public OrderDetailsId getId() {
        return id;
    }

    public void setId(OrderDetailsId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
