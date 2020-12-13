package com.example.demo.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  UserRepository userRepository;

  PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public User save(User user){
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    return this.userRepository.save(user);
  }

}
