package org.aibles.okr_team1.configuration;

import org.aibles.okr_team1.repository.HistorysRepository;
import org.aibles.okr_team1.service.HistoryService;
import org.aibles.okr_team1.service.impl.HistoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.okr_team1.repository")
@ComponentScan(basePackages = "org.aibles.okr_team1.repository")
public class HistoryConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
  @Bean
  public HistoryService historyService (HistorysRepository historysRepository, WorkerMapper modelMapper) {
    return new HistoryServiceImpl(historysRepository, modelMapper);
  }

}
