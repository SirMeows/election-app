package special.person.templbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CandidateNotFoundException extends ResponseStatusException {

    private static final String MESSAGE_ID = "Candidate with id '%x' not found";
    private static final String MESSAGE_SEARCH_TERM = "Candidate with searchTerm '%s' not found";

    public CandidateNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format(MESSAGE_ID, id));
    }

    public CandidateNotFoundException(String searchTerm) {
        super(HttpStatus.NOT_FOUND, String.format(MESSAGE_SEARCH_TERM, searchTerm));
    }
}
