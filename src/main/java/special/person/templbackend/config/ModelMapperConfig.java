package special.person.templbackend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import special.person.templbackend.dto.CandidateDto;
import special.person.templbackend.dto.PartyDto;
import java.lang.reflect.Type;
import java.util.Set;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static final Type LIST_TYPE_PARTY_DTO = new TypeToken<Set<PartyDto>>() {
    }.getType();

    public static final Type LIST_TYPE_CANDIDATE_DTO = new TypeToken<Set<CandidateDto>>() {
    }.getType();
}