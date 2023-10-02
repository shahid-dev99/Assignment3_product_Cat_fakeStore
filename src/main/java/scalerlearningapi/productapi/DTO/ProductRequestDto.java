package scalerlearningapi.productapi.DTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductRequestDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

//    private RatingDto rating ;
}
