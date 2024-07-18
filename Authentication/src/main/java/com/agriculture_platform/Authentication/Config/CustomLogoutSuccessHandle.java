package com.agriculture_platform.Authentication.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandle implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        System.out.println(JwtLocalStorage.getJwt());
        if (JwtLocalStorage.getJwt()!=null) {
            JwtLocalStorage.removeJwt();
        }
        response.sendRedirect("/login?logout");
    }
}
