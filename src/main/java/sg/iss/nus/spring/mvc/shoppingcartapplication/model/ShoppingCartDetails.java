package sg.iss.nus.spring.mvc.shoppingcartapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
/**
 *
 * @author Ding Zihe
 *
 */
@Entity
@Table(name = "shopping_card_details")
public class ShoppingCartDetails implements Serializable {

    @EmbeddedId
    private ShoppingCartDetailsId id = new ShoppingCartDetailsId();

    @ManyToOne
    @MapsId("cartId") // 使用联合主键中的cardId字段
    @JoinColumn(name = "card_id")
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("productId") // 使用联合主键中的productId字段
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;



    // Getters and Setters
    public ShoppingCartDetailsId getId() {
        return id;
    }

    public void setId(ShoppingCartDetailsId id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCard(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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
}