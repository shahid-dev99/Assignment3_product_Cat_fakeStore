package scalerlearningapi.productapi.InhertenceConcepts.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  "st_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("1")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}
