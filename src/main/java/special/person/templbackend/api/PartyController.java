package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import special.person.templbackend.service.PartyService;
import special.person.templbackend.service.CandidateService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/party")
public class PartyController {

    private ModelMapper modelMapper;

    private PartyService partyService;

    private CandidateService candidateService;
}