package com.movetoinvest.api;

import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.repository.ContributionRuleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // optional, if you want real DB instead of H2
class ContributionRuleRepositoryTest {
    @Autowired
    private ContributionRuleRepository contributionRuleRepository;

    @Test
    void testSaveAndFindContributionRule() {
        ContributionRule rule = new ContributionRule();
        rule.setPercentageOfFee(0.1);
        rule.setCap(50.0);
        rule.setActive(true);

        ContributionRule saved = contributionRuleRepository.save(rule);
        Optional<ContributionRule> retrieved = contributionRuleRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals(0.1, retrieved.get().getPercentageOfFee());
    }

}
