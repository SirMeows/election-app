package special.person.templbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String tag;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Long, Candidate> candidates = new HashMap<>();*/
}
