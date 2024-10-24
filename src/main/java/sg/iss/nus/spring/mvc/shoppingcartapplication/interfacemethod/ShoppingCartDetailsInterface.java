package sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod;

import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ShoppingCartDetailsInterface {
    public void addProduct(Product product, ShoppingCart shoppingCart);
    public void removeProduct(ShoppingCart shoppingCart, Product product);
    public void removeAllProduct(ShoppingCart shoppingCart);
}
