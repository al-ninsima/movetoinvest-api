package com.movetoinvest.api;

import com.movetoinvest.api.entities.Contribution;
import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.repository.ContributionRepository;
import com.movetoinvest.api.repository.ContributionRuleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ContributionRepositoryTest {

    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private ContributionRuleRepository contributionRuleRepository;

    @Test
    void testSaveAndFindContribution() {
        // Create a sample ContributionRule
        ContributionRule rule = new ContributionRule();
        rule.setFlatAmount(10.0);
        rule.setCapAmount(50.0);
        contributionRuleRepository.save(rule);


        // Create the Contribution
        Contribution contribution = new Contribution();
        contribution.setRuleApplied(rule);
        contribution.setAmount(25.0);
        contribution.setStatus("PENDING");

        // Save and retrieve
        Contribution saved = contributionRepository.save(contribution);
        Optional<Contribution> retrieved = contributionRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals("PENDING", retrieved.get().getStatus());
        assertEquals(25.0, retrieved.get().getAmount());
        assertEquals(rule.getId(), retrieved.get().getRuleApplied().getId());
    }
}
