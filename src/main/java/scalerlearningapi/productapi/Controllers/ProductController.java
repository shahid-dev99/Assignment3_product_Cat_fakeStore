package scalerlearningapi.productapi.Controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreProductRequestDto;
import scalerlearningapi.productapi.DTO.*;
import scalerlearningapi.productapi.Exceptions.NotFoundException;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Services.PeristInDbProductService;
import scalerlearningapi.productapi.Services.PersistInDbCategoryService;
import scalerlearningapi.productapi.Services.ProductServiceBase;

import java.util.*;

@RestController
@RequestMapping("/productsget")
public class ProductController {
    //dependency injection
//    private ProductServiceBase productService;
    private PeristInDbProductService peristInDbProductService;

    public ProductController(
                             PeristInDbProductService peristInDbProductService){
//        this.productService = productSrv;
        this.peristInDbProductService =  peristInDbProductService;
    }
    @GetMapping("/category/{cat_id}")
    public List<Product> getProductCategory_id(@PathVariable("cat_id") Long id){
        return peristInDbProductService.getProductsByCategoryId(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){

//        return productService.getAllProducts(); -- fake store implementation
        List<Product> prd =  peristInDbProductService.getAllProducts();
//        Product[] out = new Product[prd.size()];
//        int i = 0;
//        for(Product product : prd){
//            out[i++] = product;
//        }
        return prd;
    }
    @GetMapping("/{productId}")
    public Product getsingleProduct(@PathVariable("productId") Long pid) throws NotFoundException{
         Optional<Product> prd =  peristInDbProductService.getsingleProduct(pid);
            if(prd.isEmpty()){
                return null;
            }else{
              return   prd.get();
            }
    }
    @PostMapping
    public Product addNewProduct(@RequestBody FakeStoreProductRequestDto product){
        FakeStoreProductRequestDto inp = new FakeStoreProductRequestDto();
        inp.setTitle(product.getTitle());
        inp.setDescription(product.getDescription());
        inp.setPrice(product.getPrice());
       return peristInDbProductService.addNewProduct(inp);
    }

    @PutMapping("/{productid}")
    public Product updateProduct(@PathVariable("productid") Long pid, @RequestBody FakeStoreProductRequestDto dto){
//        return productService.updateProduct(pid,dto);
        FakeStoreProductRequestDto changeProd = new FakeStoreProductRequestDto();
        changeProd.setDescription(dto.getDescription());
        changeProd.setTitle(dto.getTitle());
        changeProd.setImage(dto.getImage());
        changeProd.setPrice(dto.getPrice());
        return peristInDbProductService.updateProduct(pid,changeProd);

    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long pid){

//        return productService.deleteProduct(pid);
        return peristInDbProductService.deleteProduct(pid);
    }

    @PatchMapping("/{productid}")
    public Product ChangeProduct(@PathVariable("productid") Long pid, @RequestBody FakeStoreProductRequestDto dto){
        FakeStoreProductRequestDto changeProd = new FakeStoreProductRequestDto();
        changeProd.setDescription(dto.getDescription());
        changeProd.setTitle(dto.getTitle());
        changeProd.setImage(dto.getImage());
        changeProd.setPrice(dto.getPrice());
        return peristInDbProductService.changeProduct(pid,changeProd);
//        return productService.changeProduct(pid,dto);        return null;
    }

}
