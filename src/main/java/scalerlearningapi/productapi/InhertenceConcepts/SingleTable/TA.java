package scalerlearningapi.productapi.InhertenceConcepts.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("2")
public class TA extends User {
    private double averageRating;
}
