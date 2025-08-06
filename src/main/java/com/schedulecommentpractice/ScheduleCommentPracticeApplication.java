package com.schedulecommentpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleCommentPracticeApplication {

    public static void main(String[] args) {

        SpringApplication.run(ScheduleCommentPracticeApplication.class, args);
    }

}
