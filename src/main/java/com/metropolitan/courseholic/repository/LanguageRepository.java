package com.metropolitan.courseholic.repository;

import com.metropolitan.courseholic.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
