package special.person.templbackend.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import special.person.templbackend.entity.Party;
import special.person.templbackend.entity.PartyBuilder;
import special.person.templbackend.repository.PartyRepository;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@Profile("!test")
public class DevelopmentData implements ApplicationRunner {

    private PartyRepository partyRepository;
    private final List<Party> parties = new ArrayList<>();

    private void makeParties() {
        var p_1 = PartyBuilder.create().addAllFakeData().build();
        var p_2 = PartyBuilder.create().addAllFakeData().build();
        var p_3 = PartyBuilder.create().addAllFakeData().build();
        var p_4 = PartyBuilder.create().addAllFakeData().build();
        var p_5 = PartyBuilder.create().addAllFakeData().build();

        parties.addAll(List.of(p_1, p_2, p_3, p_4, p_5));
        partyRepository.saveAll(parties);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeParties();
    }
}