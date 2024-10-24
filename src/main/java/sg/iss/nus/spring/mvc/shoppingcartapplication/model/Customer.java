package sg.iss.nus.spring.mvc.shoppingcartapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import sg.iss.nus.spring.mvc.shoppingcartapplication.validation.LoginGroup;
import sg.iss.nus.spring.mvc.shoppingcartapplication.validation.RegistrationGroup;

import java.util.List;

/**
 *
 * @author Ding Zihe
 *
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cusotmer_id")
    private Long id;

    @NotBlank(message = "Name is required",groups = RegistrationGroup.class)
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters",groups = RegistrationGroup.class)
    private String name;

    @NotBlank(message = "Email is required", groups = {LoginGroup.class, RegistrationGroup.class})
    @Email(message = "Email should be valid",groups = {LoginGroup.class, RegistrationGroup.class})
    private String email;

    @NotBlank(message = "Phone is required",groups = RegistrationGroup.class)
    @Pattern(regexp = "^\\+?[0-9]{7,15}$",
            message = "Phone number must be between 7 and 15 digits and can optionally start with +",groups = RegistrationGroup.class)
    private String phone;

    @NotBlank(message = "Password is required", groups = {LoginGroup.class, RegistrationGroup.class})
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters",groups = {LoginGroup.class, RegistrationGroup.class})
    private String password;

    private String address;

    @OneToMany(mappedBy = "customer")

    private List<Order> orders;

    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;


    public Customer() {
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}
