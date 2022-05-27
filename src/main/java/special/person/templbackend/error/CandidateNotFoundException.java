package special.person.templbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CandidateNotFoundException extends ResponseStatusException {

    private static final String message = "Candidate with id '%x' not found";

    public CandidateNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format(message, id));
    }
}
