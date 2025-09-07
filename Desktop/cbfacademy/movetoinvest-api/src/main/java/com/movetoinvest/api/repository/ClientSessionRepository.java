package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.ClientSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSessionRepository extends JpaRepository<ClientSession, Long> {
}
