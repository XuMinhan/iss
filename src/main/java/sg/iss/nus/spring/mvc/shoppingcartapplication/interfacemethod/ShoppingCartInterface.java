package sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod;


import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ShoppingCartInterface {
    public Optional<ShoppingCart> getShoppingCart(long customerId);
    public void removeAll();
    public void createCustomerShoppingCart(Customer customer);

}
