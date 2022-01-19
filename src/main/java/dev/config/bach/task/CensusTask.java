package dev.config.bach.task;


import dev.repository.CensusRepository;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application-api.properties")
public class CensusTask {

private CensusRepository censusRepository;


}
