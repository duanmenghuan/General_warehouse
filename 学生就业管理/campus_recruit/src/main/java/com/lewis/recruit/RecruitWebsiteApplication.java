package com.lewis.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RecruitWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitWebsiteApplication.class, args);
    }

}
