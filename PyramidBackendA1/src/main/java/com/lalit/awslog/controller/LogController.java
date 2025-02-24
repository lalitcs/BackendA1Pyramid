//package com.lalit.awslog.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lalit.awslog.service.LogService;
//
//import java.time.Instant;
//import java.util.*;
//
//@RestController
//@RequestMapping("/logs")
//public class LogController {
//    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
//    private final LogService logService;
//    private final ObjectMapper objectMapper;
//
//    public LogController(LogService logService, ObjectMapper objectMapper) {
//        this.logService = logService;
//        this.objectMapper = objectMapper;
//    }
//
//    @PostMapping("/write")
//    public ResponseEntity<Map<String, String>> writeLog(@RequestBody Map<String, Object> logData) {
//        try {
//            long unixTimestamp = Instant.now().getEpochSecond();
//            Map<String, Object> structuredLog = new LinkedHashMap<>();
//            structuredLog.put("unix_timestamp", unixTimestamp);
//            structuredLog.put("data", logData);
//
//            String jsonLog = objectMapper.writeValueAsString(structuredLog);
//            logService.writeLog(jsonLog);
//            logger.info(jsonLog);
//
//            return ResponseEntity.ok(Map.of("message", "Log written successfully"));
//        } catch (JsonProcessingException e) {
//            return ResponseEntity.badRequest().body(Map.of("error", "Failed to process log request"));
//        }
//    }
//
//    @GetMapping("/fetch")
//    public ResponseEntity<List<String>> fetchLogs() {
//        return ResponseEntity.ok(logService.fetchLogs());
//    }
//
//    @GetMapping("/count")
//    public ResponseEntity<Map<String, Integer>> getLogCount() {
//        return ResponseEntity.ok(Map.of("logCount", logService.getLogCount()));
//    }
//}
