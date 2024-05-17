package com.ooo01.business.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AAADemoTask {
    @Scheduled(cron = "${xxx.xxx.xxx}")
    private void queryData() {
    
    }
}
