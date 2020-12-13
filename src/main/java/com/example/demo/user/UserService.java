package com.example.demo.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User save(User user){
    return this.userRepository.save(user);
  }

}
