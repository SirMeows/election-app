package special.person.templbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.entity.CandidateBuilder;
import special.person.templbackend.entity.Party;
import special.person.templbackend.entity.PartyBuilder;
import special.person.templbackend.error.CandidateAlreadyExistsException;
import special.person.templbackend.repository.CandidateRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CandidateServiceTest {

    @Mock
    CandidateRepository cRepository;

    CandidateService cService;

    Candidate c_1;

    Party p_1;

    @BeforeEach
    void setup() {
        cService = new CandidateService(cRepository);

        c_1 = CandidateBuilder.create()
                .addFirstName("Julia")
                .addLastName("Jensen")
                .build();

        p_1 = PartyBuilder.create()
                .addName("Socialistisk Folkeparti")
                .addTag("SF")
                .build();
    }

    @Test
    void addCandidateToParty() {
        Mockito.when(cRepository.save(c_1)).thenReturn(c_1);
        Mockito.when(cRepository.existsByFirstNameAndLastNameAndParty(c_1.getFirstName(),c_1.getLastName(), p_1)).thenReturn(Boolean.FALSE);

        var actual = cService.addCandidateToParty(p_1, c_1);

        assertEquals(actual.getFirstName(), c_1.getFirstName());
        assertNotNull(actual.getParty());
        assertEquals(actual.getParty().getName(), p_1.getName());

    }

    @Test
    void addCandidateToParty_candidateAlreadyIsAMember() {
        Mockito.when(cRepository.existsByFirstNameAndLastNameAndParty(c_1.getFirstName(),c_1.getLastName(), p_1)).thenReturn(Boolean.TRUE);

        assertThrows(CandidateAlreadyExistsException.class, () ->  cService.addCandidateToParty(p_1, c_1));
    }
}