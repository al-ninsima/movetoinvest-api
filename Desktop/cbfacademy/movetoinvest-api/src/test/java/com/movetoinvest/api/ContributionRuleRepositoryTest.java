//ContributionRuleRepositoryTest for testing repository / database behaviour

package com.movetoinvest.api;

import com.movetoinvest.api.entities.ContributionRule;
import com.movetoinvest.api.entities.Portfolio;
import com.movetoinvest.api.repository.ContributionRuleRepository;
import com.movetoinvest.api.repository.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ContributionRuleRepositoryTest {

    @Autowired
    private ContributionRuleRepository contributionRuleRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    void testSavePercentageRule() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Growth Portfolio");
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        ContributionRule rule = new ContributionRule();
        rule.setRuleType(ContributionRule.RuleType.PERCENTAGE);
        rule.setPercentageValue(10.0);
        rule.setCapAmount(100.0);
        rule.setPortfolio(savedPortfolio);

        ContributionRule saved = contributionRuleRepository.save(rule);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getRuleType()).isEqualTo(ContributionRule.RuleType.PERCENTAGE);
        assertThat(saved.getPercentageValue()).isEqualTo(10.0);
        assertThat(saved.getCapAmount()).isEqualTo(100.0);
        assertThat(saved.getPortfolio().getName()).isEqualTo("Growth Portfolio");
    }

    @Test
    void testSaveFlatRule() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Flat Fee Portfolio");
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        ContributionRule rule = new ContributionRule();
        rule.setRuleType(ContributionRule.RuleType.FLAT);
        rule.setFlatAmount(50.0);
        rule.setCapAmount(200.0);
        rule.setPortfolio(savedPortfolio);

        ContributionRule saved = contributionRuleRepository.save(rule);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getRuleType()).isEqualTo(ContributionRule.RuleType.FLAT);
        assertThat(saved.getFlatAmount()).isEqualTo(50.0);
        assertThat(saved.getCapAmount()).isEqualTo(200.0);
        assertThat(saved.getPortfolio().getName()).isEqualTo("Flat Fee Portfolio");
    }
}
