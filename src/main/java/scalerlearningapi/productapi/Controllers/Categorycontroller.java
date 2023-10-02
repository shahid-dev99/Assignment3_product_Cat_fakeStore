package scalerlearningapi.productapi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Services.CategoryServiceBase;

@RestController
@RequestMapping("/categories")
public class Categorycontroller {
    private CategoryServiceBase catSrv;

    public Categorycontroller(CategoryServiceBase catSrv){
        this.catSrv = catSrv;
    }

    @GetMapping
    public String[] getAllCategory(){
        return catSrv.getAllCategory();
    }

    @GetMapping("/products/{CategoryId}")
    public ProductRequestDto[] getProductsInCategory(@PathVariable("CategoryId") String cid){
        return catSrv.getProductsInCategory(cid);
    }
}
