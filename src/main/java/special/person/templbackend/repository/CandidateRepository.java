package special.person.templbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import special.person.templbackend.entity.Candidate;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    default Map<Long, Candidate> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Candidate::getId, v -> v));
    }
}