package com.monstarlab.testprofile.user;

import com.monstarlab.testprofile.TestProfileApplication;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@SpringBootTest(classes = TestProfileApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
class UserServiceIT {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MockMvc mockMvc;

  @Test
  void retrieveSavedUser() throws Exception {
    //GIVEN
    var user = new User();
    user.setFirstname("Name");
    user.setLastname("Lastname");
    userRepository.save(user);

    //WHEN
    mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))

    //THEN
            .andExpect((MockMvcResultMatchers.status().isOk()))
            .andExpect(result -> {
              var content = result.getResponse().getContentAsString();
              Assertions.assertThat(content).contains("Lastname");
            });
  }
}
