package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ProductInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ShoppingCartDetailsInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ShoppingCartInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;

import java.util.List;
import java.util.Optional;
/**
 * This class handle browse product and add to the shopping cart
 *
 * @author Ding Zihe
 * @author Zhang Yuyue
 *
 */
@Controller
public class ProductController {
    @Autowired
    private ProductInterface productInterface;
    @Autowired
    private ShoppingCartInterface shoppingCartInterface;
    @Autowired
    private ShoppingCartDetailsInterface shoppingCartDetailsInterface;

    //Show different products pages
    @GetMapping("/outfits/sportswear")
    public String sportswear(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Sportswear");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/sportswear";
    }

    @GetMapping("/outfits/footwear")
    public String footwear(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Footwear");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/footwear";
    }

    @GetMapping("/outfits/handbags")
    public String handbags(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Handbags");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/handbags";
    }

    @GetMapping("/outfits/jewelry")
    public String jewelry(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Jewelry");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/jewelry";
    }

    @GetMapping("/outfits/mensclothing")
    public String mensclothing(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Men’s Clothing");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/mensclothing";
    }

    @GetMapping("/outfits/womensclothing")
    public String womensclothing(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Women’s Clothing");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/womensclothing";
    }

    @GetMapping("/outfits/watches")
    public String watches(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Watches");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/outfits/watches";
    }

    @GetMapping("/electronics/mobilephones")
    public String mobilephones(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Mobile Phones");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/electronics/mobilephones";
    }

    @GetMapping("/electronics/laptops")
    public String laptops(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Laptops");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/electronics/laptops";
    }

    @GetMapping("/snacks/biscuits")
    public String biscuits(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Biscuits");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/biscuits";
    }

    @GetMapping("/snacks/chocolates")
    public String chocolates(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Chocolates");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/chocolates";
    }

    @GetMapping("/snacks/chips")
    public String chips(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Chips");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/chips";
    }

    @GetMapping("/snacks/nuts")
    public String nuts(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Nuts");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/nuts";
    }

    @GetMapping("/snacks/candies")
    public String candies(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Candies");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/candies";
    }

    @GetMapping("/snacks/driedfruits")
    public String driedfruits(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Dried Fruits");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/driedfruits";
    }

    @GetMapping("/snacks/rtesnacks")
    public String rtesnacks(Model model, HttpServletRequest request) {
        List<Product> existProduct = productInterface.getProductsByCategory("Ready-to-Eat Snacks");
        model.addAttribute("productList", existProduct);
        model.addAttribute("returnAddress", request.getRequestURI());
        return "/snacks/rtesnacks";
    }


    //Add to the shopping cart
    @PostMapping("/add-shopping-card")
    public String add(@RequestParam("productId") int id, @RequestParam(value = "returnAddress",required = false) String returnAddress, @RequestParam(value = "query", required = false) String query, RedirectAttributes redirectAttributes, Model model, HttpSession session, HttpServletRequest request) {
       Optional<Product> addProduct = productInterface.getProduct(id);
       if (addProduct.isPresent()) {
          Optional<ShoppingCart> myShoppingcard = shoppingCartInterface.getShoppingCart((long)session.getAttribute("loggingCustomerId"));
          if(myShoppingcard.isPresent()) {
              shoppingCartDetailsInterface.addProduct(addProduct.get(), myShoppingcard.get());
              //"boolean", "true" is used for js to show the result whether you add successfuly
              redirectAttributes.addFlashAttribute("boolean", "true");
              //here is used for add shopping card in research page because the page is dynamic so
              //we can not return it directly
              if(returnAddress == null) {
                  return "redirect:/search?query=" + query;
              }
              return "redirect:" + returnAddress;
          }
       }
        redirectAttributes.addFlashAttribute("boolean", "false");
        return "redirect:" + returnAddress;
    }
}
