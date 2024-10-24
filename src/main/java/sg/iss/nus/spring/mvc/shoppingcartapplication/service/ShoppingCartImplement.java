package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ShoppingCartInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ShoppingCartDetailsRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ShoppingCartRepository;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
@Service
public class ShoppingCartImplement implements ShoppingCartInterface {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ShoppingCartDetailsRepository shoppingCartDetailsRepository;


    @Override
    public Optional<ShoppingCart> getShoppingCart(long customerId){
        return shoppingCartRepository.findByCustomerId(customerId);
    }

    @Override
    public void removeAll(){
        try {
            shoppingCartDetailsRepository.deleteAll();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCustomerShoppingCart(Customer customer){
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setCustomer(customer);
            shoppingCartRepository.save(shoppingCart);
        }

}
