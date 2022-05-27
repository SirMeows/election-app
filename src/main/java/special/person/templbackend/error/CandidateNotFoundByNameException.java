package special.person.templbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CandidateNotFoundByNameException extends ResponseStatusException {

    private static final String message = "Candidate with firstName '%s' lastName '%s' not found";

    public CandidateNotFoundByNameException(String firstName, String lastName) {
        super(HttpStatus.NOT_FOUND, String.format(message, firstName, lastName));
    }
}
