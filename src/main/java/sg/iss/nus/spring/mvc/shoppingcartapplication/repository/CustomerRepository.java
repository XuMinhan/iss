package sg.iss.nus.spring.mvc.shoppingcartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;

import java.util.Optional;

/**
 *
 * @author Ding Zihe
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsByPhone(String phone);

}
