package special.person.templbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import special.person.templbackend.entity.Party;
import special.person.templbackend.repository.PartyRepository;
import java.util.Set;

@AllArgsConstructor
@Service
public class PartyService {

    PartyRepository partyRepository;

    public Set<Party> getParties() {
        return partyRepository.findAllSet();
    }
}
