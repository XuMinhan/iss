package sg.iss.nus.spring.mvc.shoppingcartapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interfacemethod.CustomerAuthInterface;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.CustomerRepository;

import java.util.Optional;
/**
 *
 * @author Ding Zihe
 *
 */
@Service
@Transactional(readOnly = true)
public class CustomerAuthImplement implements CustomerAuthInterface {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer checkCustomer(String email, String password){
        Optional<Customer> loginCustomer = customerRepository.findByEmail(email);
        if(loginCustomer.isPresent()){
            if(loginCustomer.get().getPassword().equals(password)){
                return loginCustomer.get();
            }
            else {
                throw  new RuntimeException("Invalid password");
            }
        }
        else {
            throw new RuntimeException("Email not found");
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void createCustomer(Customer customer) {
        if(customerRepository.existsByEmail(customer.getEmail()) ||
                customerRepository.existsByPhone(customer.getPhone()
        )){
            throw  new RuntimeException("Email or phone already in use");
        }
        else {
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer getCustomer(String email){
        Optional<Customer> loginCustomer = customerRepository.findByEmail(email);
        if(loginCustomer.isPresent()){
            return loginCustomer.get();
        }
        else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public Customer getCustomerById(long customerId){
        if(customerRepository.findById((int)customerId).isPresent()){
            return customerRepository.findById((int)customerId).get();
        }
       else {
           throw new RuntimeException("Not found");
        }
    }


}
