package sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod;

import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Order;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.OrderDetails;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Ding Zihe
 * @author Hu Lunwei
 */
public interface OderInterface {
    public void createOrder(Order order);
    public Optional<Order> getOderById(long id);
    List<Order> getOrdersByCustomerId(long customerId);
    List<OrderDetails> getOrderDetailsByOrderId(long orderId);
    List<Product> getProductByProductId(long productId);
}
