package scalerlearningapi.productapi.InhertenceConcepts.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  "tpc_Mentor")
public class Mentor extends User{
    private int numberOfSessions;
    private int numberOfMentees;
}
