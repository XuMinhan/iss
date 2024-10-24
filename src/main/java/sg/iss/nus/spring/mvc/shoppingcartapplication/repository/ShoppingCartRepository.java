package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    public Optional<ShoppingCart> findByCustomerId(Long customerId);
}
