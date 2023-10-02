package scalerlearningapi.productapi.DTO;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewProductReqDto {
    @Nullable
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
