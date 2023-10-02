package scalerlearningapi.productapi.DTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import scalerlearningapi.productapi.Models.Category;
@Getter
@Setter
public class SingleProductRespDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String imageUrl;
    @Nullable
    private RatingDto rating ;
}
