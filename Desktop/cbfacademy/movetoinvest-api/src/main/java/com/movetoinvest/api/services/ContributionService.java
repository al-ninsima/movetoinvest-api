package com.movetoinvest.api.services;

import com.movetoinvest.api.entities.ClientSession;
import com.movetoinvest.api.entities.Contribution;
import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.repository.ContributionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionService {

    private final ContributionRepository contributionRepository;

    public ContributionService(ContributionRepository contributionRepository) {
        this.contributionRepository = contributionRepository;
    }

    public Contribution saveContribution(ClientSession session, ContributionRule rule) {
        Contribution contribution = new Contribution();
        contribution.setSession(session);
        contribution.setRuleApplied(rule);

        // Calculate contribution amount based on rule type
        double amount = 0.0;
        if (ContributionRule.PERCENTAGE.equals(rule.getRuleType())) {
            amount = session.getFee() * (rule.getPercentageValue() / 100.0);
            if (rule.getCapAmount() > 0 && amount > rule.getCapAmount()) {
                amount = rule.getCapAmount();
            }
        } else if (ContributionRule.FLAT.equals(rule.getRuleType())) {
            amount = rule.getFlatAmount();
            if (rule.getCapAmount() > 0 && amount > rule.getCapAmount()) {
                amount = rule.getCapAmount();
            }
        }

        contribution.setAmount(amount);
        contribution.setStatus("PENDING"); // default status

        return contributionRepository.save(contribution);
    }

    public List<Contribution> getAllContributions() {
        return contributionRepository.findAll();
    }

    public Contribution getContributionById(Long id) {
        return contributionRepository.findById(id).orElse(null);
    }
}

