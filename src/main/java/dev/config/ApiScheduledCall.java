package dev.config;


import dev.entity.Pollution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;


@Configuration
@EnableScheduling
public class ApiScheduledCall {

    private final Logger LOGGER = LoggerFactory.getLogger(ApiScheduledCall.class);

    private final ApplicationContext context;

    public ApiScheduledCall(ApplicationContext context) {
        this.context = context;
    }

    //    @Scheduled(cron = "0 0 6 * * ?")
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        Pollution pollution = context.getBean("runPollutionTask", Pollution.class);

        LOGGER.info("{} polution entity to save {} ", LocalDateTime.now(), pollution);
    }

}
