package com.monstarlab.testprofile.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class UserController {

  private final UserService service;

  @GetMapping("/user")
  Iterable<User> findAll() {
    return service.findAll();
  }

  @PostMapping("/user")
  User newUser(@RequestBody User newUser) {
    return service.createNew(newUser);
  }

  @GetMapping("/user/{id}")
  User findUser(@PathVariable Long id) {
    return service.getUser(id);
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    service.deleteUser(id);
  }
}
