package scalerlearningapi.productapi.InhertenceConcepts.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  "Mp_Mentor")

public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}
