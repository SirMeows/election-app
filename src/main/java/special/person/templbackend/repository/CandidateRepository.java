package special.person.templbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.entity.Party;
import java.util.HashSet;
import java.util.Set;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    default Set<Candidate> findAllSet() {
        return new HashSet<>(findAll());
    }

    Set<Candidate> findCandidatesByParty_Id(Long partyId);

    boolean existsByFirstNameAndLastNameAndParty(String firstName, String lastName, Party party);

    Set<Candidate> findByFirstNameOrLastName(String firstName, String lastName);
}