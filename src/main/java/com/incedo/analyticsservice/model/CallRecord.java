package com.incedo.analyticsservice.model;

import java.time.LocalDateTime;

public class CallRecord {
    private Long id;
    private String caller;
    private String callee;
    private LocalDateTime timestamp;
    private int duration;
    private String callType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getCallee() {
		return callee;
	}
	public void setCallee(String callee) {
		this.callee = callee;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}

    
}
