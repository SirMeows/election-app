package special.person.templbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.repository.CandidateRepository;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Service
public class CandidateService {

    private CandidateRepository candidateRepository;

    public Map<Long, Candidate> getCandidates() {
        return candidateRepository.findAllMap();
    }

    public Set<Candidate> getCandidatesByParty(Long partyId) {
        return candidateRepository.findCandidatesByParty_Id(partyId);
    }
}
