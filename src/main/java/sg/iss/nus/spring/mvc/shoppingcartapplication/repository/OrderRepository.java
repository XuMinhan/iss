package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Order;

import java.util.List;
/**
 *
 * @author Ding Zihe
 * @author Hu Lunwei
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(long customerId);
}
