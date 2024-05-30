package com.incedo.analyticsservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.incedo.analyticsservice.model.CallRecord;

@FeignClient(name = "callRecordService", url ="http://localhost:8081/call-records")
public interface CallRecordServiceClient {

    @GetMapping
    List<CallRecord> getAllCallRecords();
}