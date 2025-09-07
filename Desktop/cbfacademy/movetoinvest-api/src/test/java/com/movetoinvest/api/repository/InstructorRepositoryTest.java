package com.movetoinvest.api.repository;

import com.movetoinvest.api.entities.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testSaveAndFindInstructor() {
        Instructor instructor = new Instructor();
        instructor.setName("Alice");

        entityManager.persistAndFlush(instructor);

        Optional<Instructor> found = instructorRepository.findById(instructor.getId());
        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().getName());
    }
}

