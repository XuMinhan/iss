package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.CustomerAuthInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ShoppingCartInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;
import sg.iss.nus.spring.mvc.shoppingcartapplication.validation.LoginGroup;
import sg.iss.nus.spring.mvc.shoppingcartapplication.validation.RegistrationGroup;
import sg.iss.nus.spring.mvc.shoppingcartapplication.validator.CustomerAuthValidator;

/**
 * This class handle login\sign up
 *
 * @author Ding Zihe
 *
 */
@Controller
public class AuthController {
    @Autowired
    private CustomerAuthInterface customerAuthInterface;

    @Autowired
    private ShoppingCartInterface shoppingCartInterface;

    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }




    @PostMapping("/login")
    public String loginSubmit(@Validated(LoginGroup.class) @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult, Model model, HttpSession session,
                              RedirectAttributes redirectAttributes) {
        try { // Pass the error message to the front end
            if (bindingResult.hasErrors()) {
                model.addAttribute("bindingResult", bindingResult);
                return "login";
            }
            Customer loginCustomer = customerAuthInterface.checkCustomer(customer.getEmail(), customer.getPassword());
            if (loginCustomer == null) {
                model.addAttribute("errors", "Invalid email or password");
                return "login";
            }
            //Login successfully jump to personal page
            long loggingCustomerId = loginCustomer.getId();
            String loggingCustomerName = loginCustomer.getName();
            session.setAttribute("loggingCustomerId", loggingCustomerId);
            session.setAttribute("loggingCustomerName", loggingCustomerName);
            redirectAttributes.addFlashAttribute("successMessage", "login successfully, Welcome " + loginCustomer.getName());
            return "redirect:/personal_center";

        } catch (Exception e) {
            model.addAttribute("errors", e.getMessage());
            return "login";
        }
    }


    @GetMapping("/signup")
    public String createAccount(Model model) {
        model.addAttribute("customer",new Customer());
        return "signup";
    }

    @PostMapping("/signup")
    public String createAccount(@RequestParam("re_password") String re_password,
                                @Validated(RegistrationGroup.class) @ModelAttribute("customer") Customer customer,
                                BindingResult bindingResult, Model model, HttpSession session,
                                RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("bindingResult",bindingResult);
                return "signup";
            }
            // Enter again required
            if (re_password.isEmpty()) {
                model.addAttribute("errors_1", "Type your password again");
                return "signup";
            } else if (!re_password.equals(customer.getPassword())) {
                model.addAttribute("errors_2", "Passwords do not match");
                return "signup";
            }
            customerAuthInterface.createCustomer(customer);
            shoppingCartInterface.createCustomerShoppingCart(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Register successfully, please login!");
            return "redirect:/login";//跳回登录页
        } catch (Exception e) {
            model.addAttribute("errors", e.getMessage());
            return "signup";
        }
    }

}


