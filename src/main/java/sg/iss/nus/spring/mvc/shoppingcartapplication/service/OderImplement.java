package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.OderInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Order;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.OrderDetails;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.OrderDetailsRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.OrderRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Hu Lunwei
 *
 */
@Service
public class OderImplement implements OderInterface {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
    @Override
    public Optional<Order> getOderById(long id){
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getOrdersByCustomerId(long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public List<Product> getProductByProductId(long productId) {
        return productRepository.findByProductId(productId);
    }


}
