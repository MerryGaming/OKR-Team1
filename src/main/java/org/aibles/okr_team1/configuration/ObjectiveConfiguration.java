package org.aibles.okr_team1.configuration;

import org.aibles.okr_team1.repository.ObjectiveRepository;
import org.aibles.okr_team1.service.ObjectiveService;
import org.aibles.okr_team1.service.impl.ObjectiveServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.okr_team1.repository")
@ComponentScan(basePackages = "org.aibles.okr_team1.repository")
public class ObjectiveConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
  @Bean
  public ObjectiveService objectiveService (ObjectiveRepository objectiveRepository, WorkerMapper modelMapper) {
    return new ObjectiveServiceImpl(objectiveRepository, modelMapper);
  }

}
