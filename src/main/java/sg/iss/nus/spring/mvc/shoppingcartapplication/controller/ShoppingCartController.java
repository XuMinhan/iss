package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.*;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class handle checkout products and clear the products and
 * remove products
 *
 * @author Ding Zihe
 *
 */
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartInterface shoppingCartInterface;
    @Autowired
    private OrderDetailsInterface orderDetailsInterface;
    @Autowired
    private OderInterface oderInterface;
    @Autowired
    private CustomerAuthInterface customerAuthInterface;
    @Autowired
    private ShoppingCartDetailsInterface shoppingCartDetailsInterface;
    @Autowired
    private ProductInterface productInterface;

//return the products in your shopping cart
    @GetMapping("/cart")
    public ResponseEntity<ShoppingCart> cart(HttpSession session) {
        long customerId = (long) session.getAttribute("loggingCustomerId");
        Optional<ShoppingCart> myShoppingCart = shoppingCartInterface.getShoppingCart(customerId);
        if (myShoppingCart.isPresent()) {
            return ResponseEntity.ok(myShoppingCart.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

//clear all products in you shopping cart
    @DeleteMapping("/cart/clear")
    public ResponseEntity<HttpStatus> clear(HttpSession session) {
        try{
            long customerId = (long) session.getAttribute("loggingCustomerId");
            Optional<ShoppingCart> myShoppingCart = shoppingCartInterface.getShoppingCart(customerId);
            if (myShoppingCart.isPresent()) {
                shoppingCartDetailsInterface.removeAllProduct(myShoppingCart.get());
                return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //move the shopping cart products in order and order details
    @PostMapping("/cart/checkout")
    public ResponseEntity<Order> chekout(@RequestBody String address, HttpSession session) {
        long customerId = (long) session.getAttribute("loggingCustomerId");
        //create order
        Optional<ShoppingCart> myShoppingCart = shoppingCartInterface.getShoppingCart(customerId);
        Order order = new Order();
        order.setOrderAddress(address);
        order.setCustomer(customerAuthInterface.getCustomerById(customerId));
        order.setOrderDate(LocalDateTime.now());
        oderInterface.createOrder(order);
        if (myShoppingCart.isPresent()) {
            //create order details and move products in order details
            myShoppingCart.get().getShoppingCartDetailsList().stream()
                    .map(shoppingCartDetails -> {
                        OrderDetails orderDetails = new OrderDetails();
                        orderDetails.setProduct(shoppingCartDetails.getProduct());
                        orderDetails.setOrder(order);
                        orderDetails.setQuantity(shoppingCartDetails.getQuantity());
                        orderDetails.setTotalPrice(shoppingCartDetails.getQuantity() * shoppingCartDetails.getProduct().getUnitPrice());
                        orderDetailsInterface.createOrderDetails(orderDetails);
                        return orderDetails;
                    })
                    .collect(Collectors.toList());
            shoppingCartDetailsInterface.removeAllProduct(myShoppingCart.get());
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

//return the total products price you have added in your shopping cart
    @GetMapping("/cart/total-price")
    public ResponseEntity<Double> totalPrice(HttpSession session) {
        long customerId = (long) session.getAttribute("loggingCustomerId");
       Optional<ShoppingCart> myShoppingCart = shoppingCartInterface.getShoppingCart(customerId);
       if (myShoppingCart.isPresent()) {
           double sum = myShoppingCart.get().getShoppingCartDetailsList().stream().
                   map(shoppingCartDetails ->
                       shoppingCartDetails.getQuantity() * (shoppingCartDetails.getProduct().getUnitPrice()))
                   //add all price together
                   .reduce(Double::sum)
                   .orElse(0.0);
           return ResponseEntity.ok(sum);
       }
       else return ResponseEntity.notFound().build();
    }

    //remove the specific product in your shopping cart
    @DeleteMapping("/cart/remove/{productId}")
    public ResponseEntity<HttpStatus> remove(@PathVariable ("productId") long productId, HttpSession session) {
        try {
            long customerId = (long) session.getAttribute("loggingCustomerId");
            Optional<ShoppingCart> myShoppingCart = shoppingCartInterface.getShoppingCart(customerId);
            if (myShoppingCart.isPresent()) {
                shoppingCartDetailsInterface.removeProduct(myShoppingCart.get(),productInterface.getProduct(productId).get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }



}
