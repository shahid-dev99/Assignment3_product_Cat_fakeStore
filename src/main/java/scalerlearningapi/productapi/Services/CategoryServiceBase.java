package scalerlearningapi.productapi.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scalerlearningapi.productapi.DTO.ProductRequestDto;

public interface CategoryServiceBase {
        public String[] getAllCategory();


        public ProductRequestDto[] getProductsInCategory(String cid);


}
