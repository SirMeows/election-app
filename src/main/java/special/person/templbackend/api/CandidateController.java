package special.person.templbackend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import special.person.templbackend.dto.CandidateDto;
import special.person.templbackend.service.CandidateService;
import java.util.Set;
import static special.person.templbackend.config.ModelMapperConfig.LIST_TYPE_CANDIDATE_DTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    ModelMapper modelMapper;

    CandidateService candidateService;

    @GetMapping
    Set<CandidateDto> getCandidates() {
        var entities = candidateService.getCandidates();
        Set<CandidateDto> dtos = modelMapper.map(entities, LIST_TYPE_CANDIDATE_DTO);
        return dtos;
    }

    @GetMapping("/{id}")
    CandidateDto getCandidateById(@PathVariable Long id) {
        var entity = candidateService.getCandidateById(id);
        return modelMapper.map(entity, CandidateDto.class);
    }

    @DeleteMapping("/{id}")
    void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }
}
