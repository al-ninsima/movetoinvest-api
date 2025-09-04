package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.ContributionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;  

public interface ContributionRuleRepository extends JpaRepository<ContributionRule, Long> {
  List<ContributionRule> findByActiveTrue();
}