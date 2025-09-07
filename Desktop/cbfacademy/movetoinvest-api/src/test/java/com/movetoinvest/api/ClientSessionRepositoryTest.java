package com.movetoinvest.api;

import com.movetoinvest.api.entities.GroupClassSession;
import com.movetoinvest.api.repository.ClientSessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.time.LocalDateTime;

@DataJpaTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientSessionRepositoryTest {

  @Autowired
    private ClientSessionRepository clientSessionRepository;

    @Test
    void testFindByInstructorIdAndDateRange() {
        GroupClassSession session = new GroupClassSession();
        session.getInstructor().setId(123L);
        session.setDateTime(LocalDateTime.now());
        session.setDurationMinutes(60);
        session.setFee(100.0);
        clientSessionRepository.save(session);


    }
}
