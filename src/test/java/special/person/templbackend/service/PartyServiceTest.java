package special.person.templbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import special.person.templbackend.repository.PartyRepository;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PartyServiceTest {

    private PartyService pService;

    @Autowired
    private PartyRepository pRepository;

    @BeforeEach
    void setUp() {
        pService = new PartyService(pRepository);
    }

    @Test
    void getParties_repositoryIsEmpty() {
        assertEquals(0, pService.getParties().size());
    }
}