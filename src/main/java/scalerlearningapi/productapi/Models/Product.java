package scalerlearningapi.productapi.Models;

import lombok.Getter;
import lombok.Setter;
import scalerlearningapi.productapi.DTO.RatingDto;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private Category category;
    private String imageUrl;
    private RatingDto rating ;
}
