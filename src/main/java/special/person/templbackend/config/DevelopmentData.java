package special.person.templbackend.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import special.person.templbackend.entity.Candidate;
import special.person.templbackend.entity.CandidateBuilder;
import special.person.templbackend.entity.Party;
import special.person.templbackend.entity.PartyBuilder;
import special.person.templbackend.repository.CandidateRepository;
import special.person.templbackend.repository.PartyRepository;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@Profile("!test")
public class DevelopmentData implements ApplicationRunner {

    private PartyRepository partyRepository;
    private CandidateRepository candidateRepository;
    private final List<Party> parties = new ArrayList<>();
    private final List<Candidate> candidates = new ArrayList<>();

    private void makeParties() {
        var p_1 = PartyBuilder.create("Socialdemokratiet", "A").build();
        var p_2 = PartyBuilder.create("Det konservative Folkeparti", "C").build();
        var p_3 = PartyBuilder.create("Socialistisk Folkeparti", "F - SF").build();
        var p_4 = PartyBuilder.create("Venstre, Danmarks Liberale Parti", "V").build();
        var p_5 = PartyBuilder.create("Enhedslisten + De Rød Grønne", "Ø").build();

        parties.addAll(List.of(p_1, p_2, p_3, p_4, p_5));
        partyRepository.saveAll(parties);
    }

    private void makeCandidates() {
        var c_1 = CandidateBuilder.create("Marcel", "Meijer", parties.get(0)).build();
        var c_2 = CandidateBuilder.create("Helle", "Hansen", parties.get(0)).build();
        var c_3 = CandidateBuilder.create("Sigfred", "Jensen", parties.get(1)).build();
        var c_4 = CandidateBuilder.create("Per", "Hingel", parties.get(1)).build();
        var c_5 = CandidateBuilder.create()
                .addParty(parties.get(2))
                .addFakeNames()
                .build();
        var c_6 = CandidateBuilder.create()
                .addParty(parties.get(3))
                .addFakeNames()
                .build();
        var c_7 = CandidateBuilder.create()
                .addParty(parties.get(4))
                .addFakeNames()
                .build();


        candidates.addAll(List.of(c_1, c_2, c_3, c_4, c_5, c_6,c_7));
        candidateRepository.saveAll(candidates);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeParties();
        makeCandidates();
    }
}