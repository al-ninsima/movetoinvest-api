package com.movetoinvest.api;

import com.movetoinvest.api.entities.Portfolio;
import com.movetoinvest.api.repository.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // optional, if you want real DB instead of H2
class PortfolioRepositoryTest {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    void testSaveAndFindPortfolio() {
        // Create a Portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Growth Portfolio");
        portfolio.setRiskLevel("High");

        // Save to the DB
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        // Retrieve from DB
        Optional<Portfolio> retrieved = portfolioRepository.findById(savedPortfolio.getId());

        // Assertions
        assertTrue(retrieved.isPresent(), "Portfolio should be found in the DB");
        assertEquals("Growth Portfolio", retrieved.get().getName());
        assertEquals("High", retrieved.get().getRiskLevel());
    }

    @Test
    void testUpdatePortfolio() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Balanced Portfolio");
        portfolio.setRiskLevel("Medium");
        Portfolio saved = portfolioRepository.save(portfolio);

        // Update field
        saved.setRiskLevel("Low");
        Portfolio updated = portfolioRepository.save(saved);

        assertEquals("Low", updated.getRiskLevel(), "Risk level should be updated");
    }

    @Test
    void testDeletePortfolio() {
        Portfolio portfolio = new Portfolio();
        portfolio.setName("Delete Portfolio");
        portfolio.setRiskLevel("Low");
        Portfolio saved = portfolioRepository.save(portfolio);

        portfolioRepository.delete(saved);

        Optional<Portfolio> deleted = portfolioRepository.findById(saved.getId());
        assertFalse(deleted.isPresent(), "Portfolio should be deleted");
    }

}
