package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.ProductInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
@Service
public class ProductImplement implements ProductInterface {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProduct(long productId){
        return productRepository.findById(productId);
    }
    @Override
    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }
    @Override
    public List<Product> getProductsByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }


}
