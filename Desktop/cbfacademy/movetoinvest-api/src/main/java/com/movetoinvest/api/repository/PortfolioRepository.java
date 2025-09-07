package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    // Custom queries can be added here if needed
}
