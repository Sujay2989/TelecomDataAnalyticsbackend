package com.incedo.analyticsservice.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.analyticsservice.client.CallRecordServiceClient;
import com.incedo.analyticsservice.model.CallRecord;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
	
	@Autowired
	private CallRecordServiceClient callRecordServiceClient;
	
	@GetMapping("/total-calls")
	public long getTotalCalls() {
		List<CallRecord> callRecords= callRecordServiceClient.getAllCallRecords();
		return callRecords.size();
	}
	
	
	@GetMapping("/total-duration")
	public int getTotalDuration() {
		List<CallRecord> callRecords = callRecordServiceClient.getAllCallRecords();
		return callRecords.stream().mapToInt(CallRecord::getDuration).sum();
		
	}
	
	@GetMapping("/durations")
	public List<Integer> getCallDurations(){
		List<CallRecord> callRecords= callRecordServiceClient.getAllCallRecords();
		return callRecords.stream().map(CallRecord::getDuration).collect(Collectors.toList());
	}
	
	@GetMapping("/call-types")
	public Map<String, Long >getCallTypesCount(){
		List<CallRecord> callRecords = callRecordServiceClient.getAllCallRecords();
		return callRecords.stream().collect(Collectors.groupingBy(CallRecord::getCallType, Collectors.counting()));
	}
}