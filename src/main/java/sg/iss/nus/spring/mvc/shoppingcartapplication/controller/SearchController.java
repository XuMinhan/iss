package sg.iss.nus.spring.mvc.shoppingcartapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ProductInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;

import java.util.List;

/**
 * This class handle search products
 *
 * @author Hu Lunwei
 *
 */
@Controller
public class SearchController {

    @Autowired
    ProductInterface productInterface;

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public String search(@RequestParam(value = "query",required = false) String query, Model model) {
        List<Product> productList;
        // 检查 query 参数是否为空或者只有空格
        if (query == null || query.trim().isEmpty()) {
            // 如果 query 为空，可以返回所有产品
            productList = productInterface.getAllProducts();
        } else {
            // 如果 query 存在且不为空，执行搜索
            productList = productInterface.getProductsByProductName(query);
        }
        model.addAttribute("productList", productList);
        model.addAttribute("query", query);
        return "search";
    }
}
