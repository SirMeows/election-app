package special.person.templbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.repository.CandidateRepository;
import java.util.Set;

@AllArgsConstructor
@Service
public class CandidateService {

    private CandidateRepository candidateRepository;

    public Set<Candidate> getCandidates() {
        return candidateRepository.findAllSet();
    }

    public Set<Candidate> getCandidatesByParty(Long partyId) {
        return candidateRepository.findCandidatesByParty_Id(partyId);
    }
}
