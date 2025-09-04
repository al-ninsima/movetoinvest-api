package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
    List<Contribution> findBySessionId(Long sessionId);
    List<Contribution> findByPortfolioId(Long portfolioId);
}
