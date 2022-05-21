package special.person.templbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CandidateDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String partyName; // = "PARTY_NAME_PLACEHOLDER"; // TODO: Add configuration to ModelMapper for getting party name from Party entity
}
