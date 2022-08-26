package org.aibles.okr_team1.configuration;

import org.aibles.okr_team1.repository.UserRepository;
import org.aibles.okr_team1.service.UserService;
import org.aibles.okr_team1.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.okr_team1.repository")
@ComponentScan(basePackages = "org.aibles.okr_team1.repository")
public class UserConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
  @Bean
  public UserService userService (UserRepository userRepository) {
    return new UserServiceImpl(userRepository);
  }

}
