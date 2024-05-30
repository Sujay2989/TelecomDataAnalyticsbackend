package com.incedo.callrecordservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.callrecordservice.model.CallRecord;
import com.incedo.callrecordservice.repository.CallRecordRepository;

@RestController
@RequestMapping("/call-records")
public class CallRecordController 
{
	@Autowired
	private CallRecordRepository repository;
	
	/*
	 * @PostMapping public CallRecord createCallRecord(@RequestBody CallRecord
	 * callRecord) { return repository.save(callRecord); }
	 */
	
	@PostMapping
	public ResponseEntity<CallRecord> addCallRecord(@RequestBody CallRecord callRecord) {
	    callRecord.setId(null); // ID will be auto-generated
	    callRecord.setTimestamp(LocalDateTime.now());
	    CallRecord savedCallRecord = repository.save(callRecord);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedCallRecord);
	}

	
	@GetMapping
	public List<CallRecord> getCallRecords(){
		return repository.findAll();
	}

}
