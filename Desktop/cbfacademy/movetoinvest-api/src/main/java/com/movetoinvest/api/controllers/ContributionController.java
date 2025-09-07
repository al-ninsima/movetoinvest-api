package com.movetoinvest.api.controllers;

import com.movetoinvest.api.entities.ClientSession;
import com.movetoinvest.api.entities.Contribution;
import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.services.ContributionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    private final ContributionService contributionService;

    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping("/calculate")
    public Contribution calculateContribution(
            @RequestParam Long sessionId,
            @RequestParam Long ruleId,
            @RequestBody ClientSession session,
            @RequestBody ContributionRule rule
    ) {
        return contributionService.saveContribution(session, rule);
    }

    @GetMapping
    public List<Contribution> getAllContributions() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public Contribution getContributionById(@PathVariable Long id) {
        return contributionService.getContributionById(id);
    }
}
