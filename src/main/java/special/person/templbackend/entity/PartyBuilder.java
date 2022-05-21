package special.person.templbackend.entity;

public class PartyBuilder {

    private Party party;

    private PartyBuilder() {
    }

    public static PartyBuilder create() {
        var partyBuilder = new PartyBuilder();
        var party = new Party();
        partyBuilder.setParty(party);
        return partyBuilder;
    }

    public static PartyBuilder create(String name, String shortName) {
        var partyBuilder = new PartyBuilder();
        var party = new Party();
        party.setName(name);
        party.setShortName(shortName);
        partyBuilder.setParty(party);
        return partyBuilder;
    }

    private void setParty(Party party) {
        this.party = party;
    }

    public PartyBuilder addName(String name) {
        party.setName(name);
        return this;
    }

    public PartyBuilder addShortName(String shortName) {
        party.setName(shortName);
        return this;
    }

    public PartyBuilder addAllFakeData() {
        party.setName("xxx party");
        party.setShortName("XX");
        return this;
    }

    public Party build() {
        var temp = party;
        party = null;
        return temp;
    }
}
