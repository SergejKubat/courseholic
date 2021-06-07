package com.metropolitan.courseholic.repository;

import com.metropolitan.courseholic.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

    List<PurchaseRecord> findAllByUserUsername(String username);

}
