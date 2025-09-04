package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.ClientSession;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSessionRepository extends JpaRepository<ClientSession, Long> {
    // Find sessions for a specific instructor
    List<ClientSession> findByInstructorId(Long instructorId);

    // Find sessions in a date range
    List<ClientSession> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    // Find sessions for an instructor in a date range
    List<ClientSession> findByInstructorIdAndDateTimeBetween(
            Long instructorId,
            LocalDateTime start,
            LocalDateTime end
    );
}
