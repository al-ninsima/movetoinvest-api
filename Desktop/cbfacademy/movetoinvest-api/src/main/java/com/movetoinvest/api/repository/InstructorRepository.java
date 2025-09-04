package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
  
}
