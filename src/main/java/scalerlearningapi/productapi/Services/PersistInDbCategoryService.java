package scalerlearningapi.productapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Repository.SqlRepository.CategoryRepo.CategoryRepository;

import java.util.List;

@Service
@Primary
public class PersistInDbCategoryService implements CategoryServiceBase{
    private CategoryRepository categoryRepository;
    @Autowired
    public void PersistInDbCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository =  categoryRepository;
    }
    @Override
    public String[] getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        int n =  categories.size();
        String[] cat  = new String[n];
        int i = 0;
        for(Category catr : categories){
            cat[i++] = catr.getName();
        }
        return cat;
    }

    @Override
    public ProductRequestDto[] getProductsInCategory(String cid) {
     //  Category category =  categoryRepository.findById(cid);
        return new ProductRequestDto[0];
    }
}
