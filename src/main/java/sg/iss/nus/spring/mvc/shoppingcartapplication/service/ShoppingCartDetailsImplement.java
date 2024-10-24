package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ShoppingCartDetailsInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCart;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.ShoppingCartDetails;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ShoppingCartDetailsRepository;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
@Service
public class ShoppingCartDetailsImplement implements ShoppingCartDetailsInterface {
    @Autowired
    private ShoppingCartDetailsRepository shoppingCartDetailsRepository;

    @Override
    public void addProduct(Product product, ShoppingCart shoppingCart) {
        // 查找是否已经存在该商品与购物车的组合
        Optional<ShoppingCartDetails> existingDetails = shoppingCartDetailsRepository
                .findByShoppingCartAndProduct(shoppingCart, product);

        if (existingDetails.isPresent()) {
            // 如果已存在，则增加数量
            ShoppingCartDetails details = existingDetails.get();
            details.setQuantity(details.getQuantity() + 1);
            shoppingCartDetailsRepository.save(details);
        } else {
            // 如果不存在，则创建新的购物车条目
            ShoppingCartDetails newDetails = new ShoppingCartDetails();
            newDetails.setProduct(product);
            newDetails.setShoppingCard(shoppingCart);
            newDetails.setQuantity(1);
            shoppingCartDetailsRepository.save(newDetails);
        }
    }
    @Override
    @Transactional
    public void removeAllProduct(ShoppingCart shoppingCart){
        shoppingCartDetailsRepository.deleteByShoppingCart(shoppingCart);
    }

    @Override
    @Transactional
    public void removeProduct(ShoppingCart shoppingCart, Product product){
            shoppingCartDetailsRepository.deleteByShoppingCartAndProduct(shoppingCart,product);
    }

}
