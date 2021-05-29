package com.metropolitan.courseholic.repository;

import com.metropolitan.courseholic.model.Lection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectionRepository extends JpaRepository<Lection, Long> {

    List<Lection> findAllBySectionId(long sectionId);

}
