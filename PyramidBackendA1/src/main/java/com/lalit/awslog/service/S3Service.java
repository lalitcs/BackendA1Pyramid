//package com.lalit.awslog.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3Object;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.InputStream;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class S3Service {
//    private final AmazonS3 s3Client;
//
//    @Value("${aws.s3.bucket}")
//    private String bucketName;
//
//    public S3Service(AmazonS3 s3Client) {
//        this.s3Client = s3Client;
//    }
//
//    //Uploads log file to S3 
//    public void uploadFile(InputStream inputStream, String key) {
//        try {
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentLength(inputStream.available());
//
//            s3Client.putObject(bucketName, key, inputStream, metadata);
//            System.out.println("File uploaded to S3: " + key);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to upload file to S3", e);
//        }
//    }
//
//    //Fetch logs from S3 
//    public List<String> fetchLogsFromS3(String key) {
//        try {
//            S3Object s3Object = s3Client.getObject(bucketName, key);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object.getObjectContent()));
//            return reader.lines().collect(Collectors.toList());
//        } catch (Exception e) {
//            throw new RuntimeException("Error fetching logs from S3", e);
//        }
//    }
//}
