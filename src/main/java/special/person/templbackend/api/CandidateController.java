package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import special.person.templbackend.dto.CandidateDto;
import special.person.templbackend.service.CandidateService;
import java.lang.reflect.Type;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    public static final Type LIST_TYPE_CANDIDATE_DTO = new TypeToken<Set<CandidateDto>>() {
    }.getType();

    ModelMapper modelMapper;

    CandidateService candidateService;

    @GetMapping
    Set<CandidateDto> getCandidates() {
        var entities = candidateService.getCandidates();
        Set<CandidateDto> dtos = modelMapper.map(entities, LIST_TYPE_CANDIDATE_DTO);
        return dtos;
    }
}
