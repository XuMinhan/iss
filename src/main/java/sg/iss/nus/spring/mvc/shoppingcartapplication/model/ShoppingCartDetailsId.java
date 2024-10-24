package sg.iss.nus.spring.mvc.shoppingcartapplication.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Ding Zihe
 *
 */
@Embeddable
public class ShoppingCartDetailsId implements Serializable {

    @Column(name = "card_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;

    // Getters, Setters, equals, and hashCode
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartDetailsId)) return false;
        ShoppingCartDetailsId that = (ShoppingCartDetailsId) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }
}
