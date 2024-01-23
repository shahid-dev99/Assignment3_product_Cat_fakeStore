package scalerlearningapi.productapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductPagReqstDto {
    private int noOfRecords;
    private int offset;
}
