package com.movetoinvest.api.controllers;

import com.movetoinvest.api.entities.Contribution;
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

    @PostMapping
    public Contribution createContribution(@RequestBody Contribution contribution) {
        return contributionService.saveContribution(contribution);
    }

    @GetMapping
    public List<Contribution> getAllContributions() {
        return contributionService.getAllContributions();
    }

}
