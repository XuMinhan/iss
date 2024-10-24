package sg.iss.nus.spring.mvc.shoppingcartapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sg.iss.nus.spring.mvc.shoppingcartapplication.interceptor.AuthInterceptor;

@Component
public class WebAppConfig implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/personal_center","/add-shopping-card","/cart");
    }

}
