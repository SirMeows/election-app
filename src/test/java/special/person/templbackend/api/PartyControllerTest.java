package special.person.templbackend.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import special.person.templbackend.dto.PartyDto;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.entity.CandidateBuilder;
import special.person.templbackend.entity.Party;
import special.person.templbackend.entity.PartyBuilder;
import special.person.templbackend.repository.CandidateRepository;
import special.person.templbackend.repository.PartyRepository;
import special.person.templbackend.service.CandidateService;
import special.person.templbackend.service.PartyService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static special.person.templbackend.config.ModelMapperConfig.LIST_TYPE_PARTY_DTO;

@DataJpaTest
class PartyControllerTest {

    private ModelMapper modelMapper;

    private CandidateService cService;

    private PartyService pService;

    @Autowired
    private CandidateRepository cRepository;

    @Autowired
    private PartyRepository pRepository;

    private PartyController pController;

    private final Party sf = PartyBuilder.create("Socialistisk Folkeparti", "F - SF").build();
    private final Party venstre = PartyBuilder.create("Venstre, Danmarks Liberale Parti", "V").build();

    private final Candidate c_1 = CandidateBuilder.create().addFakeNames().addParty(sf).build();
    private final Candidate c_2 = CandidateBuilder.create().addFakeNames().addParty(sf).build();
    private final Candidate c_3 = CandidateBuilder.create().addFakeNames().addParty(venstre).build();

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
        pService = new PartyService(pRepository);
        cService = new CandidateService(cRepository);
        this.pController = new PartyController(modelMapper, pService, cService);

        pRepository.saveAll(List.of(sf, venstre));

        cRepository.saveAll(List.of(c_1, c_2,c_3));
    }

    @Test
    void getParties_modelMapper_mapsEntityToDto() {
        var entities = pService.getParties();
        Set<PartyDto> dtoSet = modelMapper.map(entities, LIST_TYPE_PARTY_DTO);
        var dtoList = dtoSet.stream().collect(Collectors.toList());
        assertTrue(PartyDto.class.isInstance(dtoList.get(0)));
    }

    @Test
    void getCandidatesForParty_repository() {
        assertEquals(2, cRepository.findCandidatesByParty_Id(sf.getId()).size());
    }

    @Test
    void getCandidatesForParty_service_doesNotContainCandidatesFromWrongParty() {
        var sfCandidates = cService.getCandidatesByParty(sf.getId());
        assertFalse(sfCandidates.contains(c_3));
    }

    @AfterEach
    void tearDown() {
        cRepository.deleteAll();
    }
}