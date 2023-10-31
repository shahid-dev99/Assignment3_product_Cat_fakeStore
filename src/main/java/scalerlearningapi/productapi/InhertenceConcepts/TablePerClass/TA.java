package scalerlearningapi.productapi.InhertenceConcepts.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")

public class TA extends User{
    private double averageRating;
}
