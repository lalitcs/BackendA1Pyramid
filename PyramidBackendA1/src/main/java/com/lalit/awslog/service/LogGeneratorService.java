package com.lalit.awslog.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@Component
public class LogGeneratorService {
    private static final long TARGET_SIZE = 10 * 1024 * 1024; // 10MB
    private static final String FILE_PATH = "C:/Users/Pc/Desktop/tmp/app_logs.log";
    private static final Random random = new Random();

    @Scheduled(fixedRate = 30000) // Runs every 30 seconds
    public void generateLogs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            long currentSize = new java.io.File(FILE_PATH).length();

            while (currentSize < TARGET_SIZE) {
                String eventName = random.nextBoolean() ? "login" : "logout"; // Random event
                long unix_timestamp = System.currentTimeMillis() / 1000; // UNIX timestamp

                String jsonLog = String.format(
                    "{\"unix_timestamp\": %d, \"data\": {\"event_name\": \"%s\"}}",
                    unix_timestamp, eventName
                );

                writer.write(jsonLog);
                writer.newLine();
                currentSize += jsonLog.getBytes().length;
            }

            System.out.println("Logs written to: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error writing logs: " + e.getMessage());
        }
    }
}
