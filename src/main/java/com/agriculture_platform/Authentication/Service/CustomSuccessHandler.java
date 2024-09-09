package com.agriculture_platform.Authentication.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


        var authourities = authentication.getAuthorities();
        var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();

        if (roles.orElse("").equals("Farmer")) {
            response.sendRedirect("/Famer-page");
        } else if (roles.orElse("").equals("Enginner")) {
            response.sendRedirect("/Enginner-page");
        }else if (roles.orElse("").equals("admin")) {
            response.sendRedirect("/admin-page");
        }
        else if (roles.orElse("").equals("technicien")) {
            response.sendRedirect("/technicien-page");
        }

        else {
            response.sendRedirect("/error");
        }



    }
}
