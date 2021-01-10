package com.example.demo.user;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User save(User user) {
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    return this.userRepository.save(user);
  }

  public User updateUser(long id, User user) {
    User inDB = userRepository.getOne(id);
    inDB.setDisplayName(user.getDisplayName());
    inDB.setLastUpdated(LocalDateTime.now());
    return userRepository.save(inDB);
  }

}
