//package com.lalit.awslog.service;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import java.io.*;
//import java.nio.file.Files;
//import java.util.List;
//
//@Service
//public class LogService {
//    private final S3Service s3Service;
//
//    @Value("${aws.s3.bucket}")
//    private String bucketName;
//
//    @Value("${aws.s3.log.key}")
//    private String s3LogKey;
//
//    @Value("${local.log.file}") // Updated to match local storage path
//    private String logFileName;
//
//    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
//
//    public LogService(S3Service s3Service) {
//        this.s3Service = s3Service;
//    }
//
//    public synchronized void writeLog(String log) {
//        File logFile = new File(logFileName);
//        ensureLogDirectoryExists(logFile);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
//            writer.write(log);
//            writer.newLine();
//        } catch (IOException e) {
//            throw new RuntimeException("Error writing log file", e);
//        }
//
//        // If file size exceeds 10MB, upload to S3 & delete local log
//        if (isFileTooLarge(logFile)) {
//            uploadLogsToS3();
//        }
//    }
//
//    private boolean isFileTooLarge(File file) {
//        return file.exists() && file.length() > MAX_FILE_SIZE;
//    }
//
//    private void ensureLogDirectoryExists(File file) {
//        File parentDir = file.getParentFile();
//        if (parentDir != null && !parentDir.exists()) {
//            parentDir.mkdirs();
//        }
//    }
//
//    //Upload logs to S3 and delete the local log file 
//    public synchronized void uploadLogsToS3() {
//        File file = new File(logFileName);
//        if (!file.exists() || file.length() == 0) {
//            System.out.println("No logs to upload.");
//            return;
//        }
//
//        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
//            s3Service.uploadFile(inputStream, s3LogKey);
//            System.out.println("Logs uploaded to S3: " + s3LogKey);
//        } catch (IOException e) {
//            throw new RuntimeException("Error uploading logs to S3", e);
//        }
//
//        // Delete local file after successful upload
//        if (file.delete()) {
//            System.out.println("Local log file deleted successfully");
//        } else {
//            System.err.println("Failed to delete local log file");
//        }
//    }
//
//    //Fetch logs from S3 instead of local file 
//    public List<String> fetchLogs() {
//        return s3Service.fetchLogsFromS3(s3LogKey);
//    }
//
//    //Get log count from S3
//    public int getLogCount() {
//        return fetchLogs().size();
//    }
//}
