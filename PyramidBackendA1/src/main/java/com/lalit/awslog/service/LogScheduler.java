package com.lalit.awslog.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogScheduler {
    private final LogService logService;

    public LogScheduler(LogService logService) {
        this.logService = logService;
    }

    //Now works properly because uploadLogsToS3() is public
    @Scheduled(fixedRate = 60000) // Runs every 60 seconds
    public void scheduledLogUpload() {
        //System.out.println("⏳ Scheduled log upload running...");
        logService.uploadLogsToS3();
    }
}
