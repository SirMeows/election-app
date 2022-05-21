package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import special.person.templbackend.dto.PartyDto;
import special.person.templbackend.entity.Party;
import special.person.templbackend.service.PartyService;
import special.person.templbackend.service.CandidateService;

import java.lang.reflect.Type;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/party")
public class PartyController {

    public static final Type LIST_TYPE = new TypeToken<Map<Long, PartyDto>>() {
    }.getType();

    private ModelMapper modelMapper;

    private PartyService partyService;

    private CandidateService candidateService;

    @GetMapping
    public Map<Long, PartyDto> getParties() {
        Map<Long, Party> entities = partyService.getParties();
        Map<Long, PartyDto> dtos = modelMapper.map(entities, LIST_TYPE);
        return dtos;
    }
}