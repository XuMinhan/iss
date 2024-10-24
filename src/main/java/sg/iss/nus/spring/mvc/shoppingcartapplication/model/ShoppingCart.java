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
@Table(name = "shopping_card")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="card_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartDetails> shoppingCartDetailsList;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<ShoppingCartDetails> getShoppingCartDetailsList() {
        return shoppingCartDetailsList;
    }
    public void setShoppingCartDetailsList(List<ShoppingCartDetails> shoppingCartDetailsList) {
        this.shoppingCartDetailsList = shoppingCartDetailsList;
    }
}
