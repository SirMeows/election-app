package special.person.templbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CandidateAlreadyExistsException extends ResponseStatusException {

    private static final String message = "Candidate with name firstName '%s' lastName '%s' in partyName '%s' already exists";

    public CandidateAlreadyExistsException(String firstName, String lastName, String partyName) {
        super(HttpStatus.FOUND, String.format(message, firstName, lastName, partyName));
    }
}
