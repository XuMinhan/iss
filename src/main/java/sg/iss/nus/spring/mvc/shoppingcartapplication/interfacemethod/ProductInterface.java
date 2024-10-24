package sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod;

import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ProductInterface {
    public List<Product> getAllProducts();
    public List<Product> getProductsByCategory(String category);
    public Optional<Product> getProduct(long productId);
    List<Product> getProductsByProductName(String productName);

}
