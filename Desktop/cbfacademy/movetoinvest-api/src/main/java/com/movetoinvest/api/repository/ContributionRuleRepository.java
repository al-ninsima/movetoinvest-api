package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.ContributionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movetoinvest.api.repository.ContributionRuleRepository;
import com.movetoinvest.api.repository.PortfolioRepository;
import java.util.List;  

public interface ContributionRuleRepository extends JpaRepository<ContributionRule, Long> {
  List<ContributionRule> findByActiveTrue();
}