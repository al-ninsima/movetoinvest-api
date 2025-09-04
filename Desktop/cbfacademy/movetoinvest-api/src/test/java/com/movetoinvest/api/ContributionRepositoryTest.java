package com.movetoinvest.api;

import com.movetoinvest.api.entities.Contribution;
import com.movetoinvest.api.repository.ContributionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // optional, if you want real DB instead of H2
class ContributionRepositoryTest {
    @Autowired
    private ContributionRepository contributionRepository;

    @Test
    void testSaveAndFindContribution() {
        Contribution contribution = new Contribution();
        contribution.setSessionId(1L);
        contribution.setPortfolioId(1L);
        contribution.setAmount(25.0);
        contribution.setStatus("PENDING");

        Contribution saved = contributionRepository.save(contribution);
        Optional<Contribution> retrieved = contributionRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals("PENDING", retrieved.get().getStatus());
    }

}
