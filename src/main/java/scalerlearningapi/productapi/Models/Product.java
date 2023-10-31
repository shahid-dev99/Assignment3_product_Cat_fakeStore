package scalerlearningapi.productapi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import scalerlearningapi.productapi.DTO.RatingDto;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
   // private RatingDto rating ;
}
