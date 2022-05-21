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

        // Socialdemokratiet
        var c_1_0 = CandidateBuilder.create("Marcel", "Meijer", parties.get(0)).build();
        var c_2_0 = CandidateBuilder.create("Helle", "Hansen", parties.get(0)).build();
        var c_3_0 = CandidateBuilder.create()
                .addParty(parties.get(2))
                .addFakeNames()
                .build();

        // Konservative
        var c_1_1 = CandidateBuilder.create("Sigfred", "Jensen", parties.get(1)).build();
        var c_2_1 = CandidateBuilder.create("Per", "Hingel", parties.get(1)).build();
        var c_3_1 = CandidateBuilder.create()
                .addParty(parties.get(1))
                .addFakeNames()
                .build();

        // Socialisterne
        var c_1_2 = CandidateBuilder.create("Ulla", "Holm", parties.get(2)).build();
        var c_2_2 = CandidateBuilder.create("Lone", "Krag", parties.get(2)).build();
        var c_3_2 = CandidateBuilder.create()
                .addParty(parties.get(2))
                .addFakeNames()
                .build();

        // Venstre
        var c_1_3 = CandidateBuilder.create("Søren", "Wiese", parties.get(3)).build();
        var c_2_3 = CandidateBuilder.create()
                .addParty(parties.get(3))
                .addFakeNames()
                .build();

        // Enhedslisten
        var c_1_4 = CandidateBuilder.create("Pia", "Birkman", parties.get(4)).build();
        var c_2_4 = CandidateBuilder.create()
                .addParty(parties.get(4))
                .addFakeNames()
                .build();

        candidates.addAll(List.of(c_1_0, c_2_0, c_3_0, c_1_1, c_2_1, c_3_1, c_1_2, c_2_2, c_3_2, c_1_3, c_2_3, c_1_4, c_2_4));
        candidateRepository.saveAll(candidates);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeParties();
        makeCandidates();
    }
}