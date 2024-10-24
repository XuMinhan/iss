package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
    //Main page jump

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        return "home";
    }

    @GetMapping("/electronics")
    public String electronics(Model model, HttpSession session) {
        return "electronics";
    }

    @GetMapping("/snacks")
    public String snacks(Model model, HttpSession session) { return "snacks"; }

    @GetMapping("/outfits")
    public String outfits(Model model, HttpSession session) {
        return "outfits";
    }



}
