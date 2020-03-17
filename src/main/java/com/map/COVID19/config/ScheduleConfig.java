package com.map.COVID19.config;

import com.map.COVID19.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    private DataLoaderService dataLoaderService;

    @Scheduled(fixedDelay = 14400000)
    public void schedule(){
        dataLoaderService.saveData();
    }
}
