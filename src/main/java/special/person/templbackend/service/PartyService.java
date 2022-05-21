package special.person.templbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import special.person.templbackend.entity.Party;
import special.person.templbackend.repository.PartyRepository;

import java.util.Map;

@AllArgsConstructor
@Service
public class PartyService {

    PartyRepository partyRepository;

    public Map<Long, Party> getParties() {
        return partyRepository.findAllMap();
    }
}
