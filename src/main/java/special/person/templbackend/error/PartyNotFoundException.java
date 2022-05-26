package special.person.templbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PartyNotFoundException extends ResponseStatusException {

    public static final String message = "Party with name %x not found";

    public PartyNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format(message, id));
    }
}