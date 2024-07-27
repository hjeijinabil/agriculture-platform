package com.agriculture_platform.Authentication.Config;

import com.agriculture_platform.Authentication.Service.CustomSuccessHandler;
import com.agriculture_platform.Authentication.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtAuthentificationFilter jwtAuthFilter;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(c -> c.disable())

                .authorizeHttpRequests(request -> request

                        .requestMatchers("/users/login").permitAll()
                        .requestMatchers("users/registration").permitAll()
                        .requestMatchers("/users/username/**").permitAll()
                        .anyRequest().authenticated()
                 )// Adjust as needed


                // configure session management
                // like this spring we'll create a new session for every request
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(customAuthenticationProvider);//authenticationProvider original
     //         .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) ;// because i want to execute this filter before UsernamePasswordAuthenticationFilter
//
//                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
//                        .successHandler(customSuccessHandler).permitAll())

//                .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessHandler(new CustomLogoutSuccessHandle())
//                        /*.logoutSuccessUrl("/login?logout")*/
//                        .permitAll());

        return http.build();

    }


    @Autowired
    public void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider); // added
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() { // added
        return new CustomAuthenticationProvider();
    }
}

