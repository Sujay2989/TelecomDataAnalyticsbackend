package com.incedo.callrecordservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incedo.callrecordservice.model.CallRecord;

public interface CallRecordRepository extends JpaRepository<CallRecord, Long> {
}