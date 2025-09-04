package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
List<Portfolio> findByInstructorId(Long instructorId);
}
