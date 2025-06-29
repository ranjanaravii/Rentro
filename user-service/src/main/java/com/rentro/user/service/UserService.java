package com.rentro.user.service;

import com.rentro.user.dto.UserRegistrationDto;
import com.rentro.user.entity.User;
import com.rentro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User registerUser(UserRegistrationDto registrationDto) {
        // Check if user already exists
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }
        
        if (registrationDto.getPhoneNumber() != null && 
            userRepository.existsByPhoneNumber(registrationDto.getPhoneNumber())) {
            throw new RuntimeException("User with this phone number already exists");
        }
        
        // Create new user
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setUserType(registrationDto.getUserType());
        user.setAddress(registrationDto.getAddress());
        user.setCity(registrationDto.getCity());
        user.setState(registrationDto.getState());
        user.setPincode(registrationDto.getPincode());
        
        return userRepository.save(user);
    }
    
    public String authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        
        if (!user.getIsActive()) {
            throw new RuntimeException("Account is deactivated");
        }
        
        // Generate JWT token (simplified for demo)
        return "jwt-token-for-user-" + user.getId();
    }
    
    public void verifyEmail(String token) {
        // Email verification logic
        // This would typically involve validating a token sent via email
        throw new RuntimeException("Email verification not implemented yet");
    }
}
