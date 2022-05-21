package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import special.person.templbackend.dto.CandidateDto;
import special.person.templbackend.dto.PartyDto;
import special.person.templbackend.entity.Party;
import special.person.templbackend.service.PartyService;
import special.person.templbackend.service.CandidateService;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/parties")
public class PartyController {

    public static final Type LIST_TYPE_PARTY_DTO = new TypeToken<Set<PartyDto>>() {
    }.getType();
    public static final Type LIST_TYPE_CANDIDATE_DTO = new TypeToken<Set<PartyDto>>() {
    }.getType();

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