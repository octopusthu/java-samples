package com.octopusthu.dev.samples.springboot.scheduledtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class SpringBootScheduledTasksSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduledTasksSampleApplication.class, args);
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void executeFirstSampleTask() {
        new InfiniteLoop("one") {
        }.run();
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void executeSecondSampleTask() {
        new InfiniteLoop("two") {
        }.run();
    }

}
