package sg.iss.nus.spring.mvc.shoppingcartapplication.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
/**
 * Interceptor works for every page which only access for customer not user
 *
 * @author Ding Zihe
 *
 */

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
       // session.setAttribute("loginURI", request.getRequestURI());
        if (session.getAttribute("loggingCustomerId") != null) {
            return true;
        }
        // If it comes from React, return the 401 status code
        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        response.sendRedirect("/login");
        return false;

    }
}
