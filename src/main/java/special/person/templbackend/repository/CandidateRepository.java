package special.person.templbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import special.person.templbackend.entity.Candidate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    default Set<Candidate> findAllSet() {
        return new HashSet<>(findAll());
    }

    Set<Candidate> findCandidatesByParty_Id(Long partyId);
}