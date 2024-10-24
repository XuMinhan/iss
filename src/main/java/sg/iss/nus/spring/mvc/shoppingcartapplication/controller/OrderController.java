package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.OderInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Order;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.OrderDetails;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class handle browse purchase history
 *
 * @author Hu Lunwei
 *
 */
@Controller
public class OrderController {

    @Autowired
    private OderInterface oderInterface; // 注入服务层

    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.removeAttribute("loggingCustomerId");
        return "redirect:/home";
    }


    @GetMapping("/personal_center")
    public String viewOrders(HttpSession session, Model model) {
        // Get the current logged-in user ID
        Long customerId = (Long) session.getAttribute("loggingCustomerId");

        if (customerId == null) {
            // If the user is not logged in, redirect to the login page
            return "redirect:/login";
        }

        // Query all orders under this customer ID
        List<Order> orders = oderInterface.getOrdersByCustomerId(customerId);

        // Store the order ID and corresponding order details
        Map<Long, List<OrderDetails>> orderDetailsMap = new HashMap<>();
        // Store the order ID and corresponding product list
        Map<Long, List<Product>> orderProductMap = new HashMap<>();
        // Store the order ID and corresponding total amount
        Map<Long, Double> orderTotalMap = new HashMap<>();

        // Iterate over the orders to get corresponding order details
        for (Order order : orders) {
            List<OrderDetails> orderDetails = oderInterface.getOrderDetailsByOrderId(order.getId());
            orderDetailsMap.put(order.getId(), orderDetails);

            // Check if the product list for this order already exists
            List<Product> productList = orderProductMap.getOrDefault(order.getId(), new ArrayList<>());

            // Calculate the total amount
            double totalAmount = 0.0;

            // Iterate over the current order details to get product information and store it
            for (OrderDetails orderDetail : orderDetails) {
                Product product = orderDetail.getProduct();
                if (product != null && !productList.contains(product)) {
                    productList.add(product);
                }
                totalAmount += orderDetail.getTotalPrice();
            }
            orderProductMap.put(order.getId(), productList);  // Update the product list
            orderTotalMap.put(order.getId(), totalAmount);    // Update the total amount
        }

        // Pass data to the view layer
        model.addAttribute("orders", orders);
        model.addAttribute("orderDetailsMap", orderDetailsMap);
        model.addAttribute("orderProductMap", orderProductMap);
        model.addAttribute("orderTotalMap", orderTotalMap);

        return "orders";
    }




}
