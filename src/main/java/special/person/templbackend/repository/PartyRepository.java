package special.person.templbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import special.person.templbackend.entity.Party;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    default Map<Long, Party> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Party::getId, v -> v));
    }
}
