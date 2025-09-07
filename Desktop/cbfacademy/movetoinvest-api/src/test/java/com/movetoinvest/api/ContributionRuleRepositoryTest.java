//ContributionRuleRepositoryTest for testing repository / database behaviour

package com.movetoinvest.api;

import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.entities.Portfolio;
import com.movetoinvest.api.repository.ContributionRuleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ContributionRuleRepositoryTest {

    @Autowired
    private ContributionRuleRepository contributionRuleRepository;


    @Test
    void testSavePercentageRule() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Growth Portfolio");

        ContributionRule rule = new ContributionRule();
        rule.setPercentageValue(10.0);
        rule.setCapAmount(100.0);

        ContributionRule saved = contributionRuleRepository.save(rule);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getPercentageValue()).isEqualTo(10.0);
        assertThat(saved.getCapAmount()).isEqualTo(100.0);
    }

    @Test
    void testSaveFlatRule() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Flat Fee Portfolio");

        ContributionRule rule = new ContributionRule();
        rule.setFlatAmount(50.0);
        rule.setCapAmount(200.0);

        ContributionRule saved = contributionRuleRepository.save(rule);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFlatAmount()).isEqualTo(50.0);
        assertThat(saved.getCapAmount()).isEqualTo(200.0);
    }
}
