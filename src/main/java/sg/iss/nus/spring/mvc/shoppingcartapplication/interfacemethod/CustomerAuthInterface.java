package sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod;

import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
public interface CustomerAuthInterface {
    public Customer checkCustomer(String email, String password);
    public void createCustomer(Customer customer);
    public Customer getCustomer(String email);
    public Customer getCustomerById(long customerId);
}
