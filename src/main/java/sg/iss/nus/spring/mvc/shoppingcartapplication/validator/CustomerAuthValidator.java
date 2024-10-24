package sg.iss.nus.spring.mvc.shoppingcartapplication.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Customer;

@Component
public class CustomerAuthValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }


}
