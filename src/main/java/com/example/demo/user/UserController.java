package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/api/1.0/users")
  public User createUser(@RequestBody User user){
    return this.userService.save(user);
  }

  @PutMapping("/api/1.0/users/{id}")
  public User updateUser(@PathVariable long id, @RequestBody User user){
    return this.userService.updateUser(id, user);
  }
  
}
