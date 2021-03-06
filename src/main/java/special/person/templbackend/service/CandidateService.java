package special.person.templbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.entity.Party;
import special.person.templbackend.error.CandidateAlreadyExistsException;
import special.person.templbackend.error.CandidateNotFoundException;
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

    public Candidate getCandidateById(Long id) {
        var candidate = candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
        return candidate;
    }

    public Candidate addCandidateToParty(Party party, Candidate newCandidate) {
        var fName = newCandidate.getFirstName();
        var lName = newCandidate.getLastName();
        //TODO:  check if exists in general, if belongs to another party, ask if want to change candidate
        if(candidateRepository.existsByFirstNameAndLastNameAndParty(fName, lName, party)) {
            throw new CandidateAlreadyExistsException(fName, lName, party.getName());
        } else {
            newCandidate.setParty(party);
            return candidateRepository.save(newCandidate);
        }
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
