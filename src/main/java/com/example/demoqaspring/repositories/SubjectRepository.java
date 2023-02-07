package com.example.demoqaspring.repositories;

import com.example.demoqaspring.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}