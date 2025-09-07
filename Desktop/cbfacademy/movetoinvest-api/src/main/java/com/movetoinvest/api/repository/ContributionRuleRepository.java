package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.ContributionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRuleRepository extends JpaRepository<ContributionRule, Long> {
}
