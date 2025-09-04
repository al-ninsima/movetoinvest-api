package com.movetoinvest.api;

import com.movetoinvest.api.entities.GroupClassSession;
import com.movetoinvest.api.entities.ClientSession;
import com.movetoinvest.api.repository.ClientSessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientSessionRepositoryTest {

  @Autowired
    private ClientSessionRepository clientSessionRepository;

    @Test
    void testFindByInstructorIdAndDateRange() {
        GroupClassSession session = new GroupClassSession();
        session.setInstructorId(1L);
        session.setDateTime(LocalDateTime.now());
        session.setDurationMinutes(60);
        session.setFee(100.0);
        clientSessionRepository.save(session);

        List<ClientSession> sessions = clientSessionRepository.findByInstructorIdAndDateTimeBetween(
                1L,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(1)
        );

        assertFalse(sessions.isEmpty());
        assertEquals(1, sessions.size());
    }
}
