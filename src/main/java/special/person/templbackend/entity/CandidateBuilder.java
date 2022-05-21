package special.person.templbackend.entity;

public class CandidateBuilder {

    private Candidate candidate;

    private CandidateBuilder() {
    }

    public static CandidateBuilder create() {
        var cBuilder = new CandidateBuilder();
        var candidate = new Candidate();
        cBuilder.setCandidate(candidate);
        return cBuilder;
    }

    public static CandidateBuilder create(String firstName, String lastName, Party party) {
        var cBuilder = new CandidateBuilder();
        var candidate = new Candidate();
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setParty(party);
        cBuilder.setCandidate(candidate);
        return cBuilder;
    }

    private void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public CandidateBuilder addFirstName(String firstName) {
        candidate.setFirstName(firstName);
        return this;
    }

    public CandidateBuilder addLastName(String lastName) {
        candidate.setLastName(lastName);
        return this;
    }

    public CandidateBuilder addParty(Party party) {
        candidate.setParty(party);
        return this;
    }

    public CandidateBuilder addFakeNames() {
        addFirstName("xxx");
        addLastName("yyy");
        return this;
    }

    public Candidate build() {
        var temp = candidate;
        candidate = null;
        return temp;
    }
}
