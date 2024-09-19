package com.agriculture_platform.Authentication.Controller;

import com.agriculture_platform.Authentication.Entity.User;
import com.agriculture_platform.Authentication.Entity.VerficationToken;
import com.agriculture_platform.Authentication.Repository.UserRepository;
import com.agriculture_platform.Authentication.Repository.VerificationTokenRepository;
import com.agriculture_platform.Authentication.Service.JwtService;
import com.agriculture_platform.Authentication.Service.MaillerService;
import com.agriculture_platform.Authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private MaillerService maillerService;

    @PostMapping("/forgotpassword")
    public ResponseEntity<?> processForgotPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        System.out.println("wwwwwwj: " + email);

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Generate the token
            String token = jwtService.generateToken((UserDetails) user);

            // Save the token in the database
            VerficationToken verificationToken = new VerficationToken(token);
            verificationTokenRepository.save(verificationToken);

            // Generate password reset link
            String resetUrl = "http://your-domain.com/reset-password?token=" + token;

            // Compose the email content
            String emailContent = "Dear " + user.getUsername() + ",\n\n"
                    + "Please click the link below to reset your password:\n"
                    + resetUrl + "\n\n"
                    + "If you didn't request this, please ignore this email.\n\n"
                    + "Best regards,\n"
                    + "Your Company Team";

            // Send the email with the reset URL
            maillerService.sendEmail(email, "Password Reset Request", emailContent);

            return ResponseEntity.ok("Password reset link has been sent to your email.");
        }

        return ResponseEntity.badRequest().body("User with the given email doesn't exist.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> processResetPassword(@RequestParam String token, @RequestParam String password) {
        VerficationToken resetToken = verificationTokenRepository.findByTokenQuery(token);
        if (resetToken != null) {
            if (resetToken.isExpired()) {
                return ResponseEntity.badRequest().body("Reset token is invalid or expired.");
            }

            String username = jwtService.extractUsername(token);
            User user = userService.getUserByEmail(username);
            if (user != null) {
                user.setPassword(passwordEncoder.encode(password));
                userRepository.save(user);
                verificationTokenRepository.delete(resetToken);
                return ResponseEntity.ok("Password reset successfully.");
            }

            return ResponseEntity.badRequest().body("Invalid token or user not found.");
        }

        return ResponseEntity.badRequest().body("Reset token is invalid or expired.");
    }



}
