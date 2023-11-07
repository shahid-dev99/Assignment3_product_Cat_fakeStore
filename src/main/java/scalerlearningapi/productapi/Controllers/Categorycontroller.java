package scalerlearningapi.productapi.Controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Services.CategoryServiceBase;
import scalerlearningapi.productapi.Services.PersistInDbCategoryService;

@RestController
@RequestMapping("/categories")
public class Categorycontroller {
    private CategoryServiceBase catSrv;
    private PersistInDbCategoryService categoryService;

    public Categorycontroller( CategoryServiceBase catSrv,
                              PersistInDbCategoryService categoryService){
        this.catSrv = catSrv;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String[] getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/products/{CategoryId}")
    public ProductRequestDto[] getProductsInCategory(@PathVariable("CategoryId") String cid){
        return catSrv.getProductsInCategory(cid);
    }
}
