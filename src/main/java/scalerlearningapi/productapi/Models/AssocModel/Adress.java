package scalerlearningapi.productapi.Models.AssocModel;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import scalerlearningapi.productapi.Models.BaseModel;

import java.util.List;
@Getter
@Setter
@Entity
public class Adress extends BaseModel {
    private String City;
    private int pinCode;
    @OneToMany(mappedBy = "adress")
    private List<Student> students;

}
