package scalerlearningapi.productapi.Models.AssocModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import scalerlearningapi.productapi.Models.BaseModel;
@Getter
@Setter
@Entity
public class Student extends BaseModel {
   private String name;
   private int roll;
   @ManyToOne
   private Adress adress;

}
