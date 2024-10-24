package sg.iss.nus.spring.mvc.shoppingcartapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
/**
 *
 * @author Ding Zihe
 *
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name ="product_name" ,nullable = false)
    private String productName;
    @Column(name ="unit_price" ,nullable = false)
    private double unitPrice;
    private String description;
    private String imageUrl;
    private String category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetails> orderDetailsList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ShoppingCartDetails> shoppingCartDetailsList;

    public Product() {}

    public Product( String name, double unitPrice, String image,String category) {
        this.productName = name;
        this.unitPrice = unitPrice;
        this.imageUrl = image;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ShoppingCartDetails> getShoppingCartDetailsList() {
        return shoppingCartDetailsList;
    }

    public void setShoppingCartDetailsList(List<ShoppingCartDetails> shoppingCartDetailsList) {
        this.shoppingCartDetailsList = shoppingCartDetailsList;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
