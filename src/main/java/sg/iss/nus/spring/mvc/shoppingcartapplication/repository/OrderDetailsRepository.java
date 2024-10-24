package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Order;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.OrderDetails;

import java.util.List;
/**
 *
 * @author Ding Zihe
 * @author Hu Lunwei
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByOrderId(long orderId);
}
