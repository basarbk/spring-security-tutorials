package com.example.demo.user;

import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user, @LoggedInUser AppUser appUser){
    if(appUser.getUser().getId() != id){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not allowed to update this user");
    }
    return ResponseEntity.ok(this.userService.updateUser(id, user));
  }
  
}
