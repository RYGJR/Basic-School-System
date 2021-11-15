package demo.softdevproject.demo.service;

import demo.softdevproject.demo.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import demo.softdevproject.demo.model.User;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}

