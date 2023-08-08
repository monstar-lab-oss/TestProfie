package com.monstarlab.testprofile.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** Provide user related functionality. */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  List<User> findAll() {
    return userRepository.findAll();
  }

  User createNew(User user) {
    return userRepository.save(user);
  }

  User getUser(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
