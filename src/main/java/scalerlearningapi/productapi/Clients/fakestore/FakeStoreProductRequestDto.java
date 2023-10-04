package scalerlearningapi.productapi.Clients.fakestore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductRequestDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

//    private RatingDto rating ;
}
