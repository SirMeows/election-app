package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import special.person.templbackend.dto.CandidateDto;
import special.person.templbackend.dto.PartyDto;
import special.person.templbackend.service.PartyService;
import special.person.templbackend.service.CandidateService;
import java.util.Set;
import static special.person.templbackend.config.ModelMapperConfig.LIST_TYPE_CANDIDATE_DTO;
import static special.person.templbackend.config.ModelMapperConfig.LIST_TYPE_PARTY_DTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/parties")
public class PartyController {

    private ModelMapper modelMapper;

    private PartyService partyService;

    private CandidateService candidateService;

    @GetMapping
    public Set<PartyDto> getParties() {
        var entities = partyService.getParties();
        Set<PartyDto> dtos = modelMapper.map(entities, LIST_TYPE_PARTY_DTO);
        return dtos;
    }

    @GetMapping("/{id}/candidates")
    public Set<CandidateDto> getCandidatesForParty(@PathVariable Long id) {
        var entities = candidateService.getCandidatesByParty(id);
        Set<CandidateDto> candidateDtos = modelMapper.map(entities, LIST_TYPE_CANDIDATE_DTO);
        return candidateDtos;
    }
}