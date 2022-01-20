package dev.config.bach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ApiScheduledCallCensus {
    private final Logger LOGGER = LoggerFactory.getLogger(ApiScheduledCallCensus.class);
    /* population data update every new year */
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void scheduleFixedDelayTask() {
        LOGGER.info("Maj population");
    }
}
