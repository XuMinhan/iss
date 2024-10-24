package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.OrderDetailsInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.OrderDetails;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.OrderDetailsRepository;
/**
 *
 * @author Ding Zihe
 * @author Hu Lunwei
 */
@Service
public class OrderDetailsImplement implements OrderDetailsInterface {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public void createOrderDetails(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }
}
