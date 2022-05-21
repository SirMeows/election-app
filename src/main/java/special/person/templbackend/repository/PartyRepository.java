package special.person.templbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import special.person.templbackend.entity.Party;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    default Set<Party> findAllSet() {
        return new HashSet<>(findAll());
    }
}
