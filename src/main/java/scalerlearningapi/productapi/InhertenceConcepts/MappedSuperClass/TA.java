package scalerlearningapi.productapi.InhertenceConcepts.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Mp_ta")
public class TA extends User {
    private double averageRating;
}
