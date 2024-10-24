package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCartDetails;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ShoppingCartDetailsRepository extends JpaRepository<ShoppingCartDetails, Integer> {
    public Optional<ShoppingCartDetails> findByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);
    public void deleteByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);
    public void deleteByShoppingCart(ShoppingCart shoppingCart);
}