package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;

import java.util.List;
/**
 *
 * @author Ding Zihe
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductId(long productId);
    List<Product> findByCategory(String category);
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    List<Product> findByProductName(@Param("name") String productName);
}
